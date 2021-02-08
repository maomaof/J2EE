package com.pbz.demo.hello.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;

public final class JsonSriptParser {
	private static final String subtitle_video_name = "vSubtitle.mp4";
	private static final String final_video_name = "vFinal.mp4";
	private static final boolean isWindows = System.getProperty("os.name").startsWith("Windows");
	private static List<Map<String, Object>> supperObjectsMapList = new ArrayList<Map<String, Object>>();

	public static boolean generateVideoByScriptFile(String scriptFilePath) throws Exception {
		String jsonString = new String(Files.readAllBytes(new File(scriptFilePath).toPath()));
		// Fix input JSON string
		int s = jsonString.indexOf("{");
		if (s > 0) {
			jsonString = jsonString.substring(s);
			int e = jsonString.lastIndexOf("}");
			jsonString = jsonString.substring(s - 1, e + 1);
			jsonString = jsonString.replaceAll("\\\\", "");
			System.out.println("Fix for this input JSON string");
		}
		return generateVideo(jsonString);
	}

	private static boolean generateVideo(String jsonString) throws Exception {
		JSONObject jsonObj = new JSONObject(jsonString);
		JSONObject requestObj = getJsonObjectbyName(jsonObj, "request");
		supperObjectsMapList.clear();
		initMap(requestObj);
		String version = requestObj.getString("version");
		System.out.println("剧本版本:" + version);
		int width = requestObj.getInt("width");
		int height = requestObj.getInt("height");
		String audioFile = requestObj.getString("music");
		String rate = requestObj.getString("rate");
		int index = 0;

		Iterator<String> keys = requestObj.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			if (key.equalsIgnoreCase("frames")) {
				JSONArray frameArray = (JSONArray) requestObj.get(key);
				for (Object frame : frameArray) {
					if (!(frame instanceof JSONObject)) {
						continue;
					}
					JSONObject frameObj = (JSONObject) frame;
					int times = frameObj.getInt("time");
					Color colorBackground = null;
					if (frameObj.has("backgroundColor")) {
						String color = frameObj.getString("backgroundColor");
						colorBackground = getColor(color);
					}
					Image bgImg = null;
					if (frameObj.has("backgroundPicture")) {
						String srcImageFile = frameObj.getString("backgroundPicture");
						File img = new File(srcImageFile);
						if (img.exists()) {
							bgImg = ImageIO.read(img);
						} else {
							System.out.println("WARNING: The file " + img.getName() + " doesn't exist!");
						}
					}
					for (int j = 0; j < times; j++) {
						String destImageFile = System.getProperty("user.dir") + "/" + Integer.toString(index + 1)
								+ ".jpg";
						BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
						Graphics2D g = image.createGraphics();
						if (colorBackground != null) {
							g.setColor(colorBackground);
							g.fillRect(0, 0, width, height);
						}
						if (bgImg != null) {
							g.drawImage(bgImg, 0, 0, width, height, null);
						}

						JSONArray objectArray = frameObj.getJSONArray("objects");
						for (Object object : objectArray) {
							JSONObject obj = (JSONObject) object;
							// Picture
							if (obj.has("picture")) {
								String picFile = obj.getString("picture");
								File imgFile = new File(picFile);
								if (imgFile.exists()) {
									Image img = ImageIO.read(imgFile);
									int left = obj.getInt("x");
									int top = obj.getInt("y");
									int w = obj.getInt("width");
									int h = obj.getInt("heigth");
									g.drawImage(img, left, top, w, h, null);
								} else {
									System.out.println("WARNING: The file " + imgFile.getName() + " doesn't exist!");
								}
							}
							// Text
							if (obj.has("text")) {
								String text = obj.getString("text");
								int x = obj.getInt("x");
								int y = obj.getInt("y");
								int size = obj.getInt("size");
								String c = obj.getString("color");
								Color color = getColor(c);
								System.out.println(text);
								g.setColor(color);
								Font font = new Font("黑体", Font.BOLD, size);
								g.setFont(font);
								g.drawString(text, x, y);
							}
							// Graphic
							if (obj.has("graphic")) {
								drawGraphic(obj, g);
							}
						}

						List<JSONObject> objs = getSuperObjectsByframeNumber(index + 1);
						for (JSONObject obj : objs) {
							drawSupperObjects(obj, g, index + 1);
						}
						g.setColor(new Color(0, 0, 255));// 帧号颜色
						g.setFont(new Font("黑体", Font.BOLD, 40));
						g.drawString(Integer.toString(index + 1), width - 100, 50);// 显示帧号
						g.dispose();
						ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));
						index++;
					}
				}
			}
		}
		String suffix = isWindows ? ".bat" : ".sh";
		String cmd = System.getProperty("user.dir") + "/" + "jpg2video" + suffix;
		String[] args = { Integer.toString(width), Integer.toString(height), rate };
		ExecuteCommand.executeCommand(cmd, args);
		String ffmpegPath = "ffmpeg";
		if (!isWindows) {
			ffmpegPath = "/usr/bin/ffmpeg";
			if (!new File(ffmpegPath).exists()) {
				ffmpegPath = "/usr/local/bin/ffmpeg";
			}
		}
		// Cut the audio
		if (!new File(audioFile).exists()) {
			throw new Exception("The audio file " + audioFile + " doesn't exist!");
		}
		String tmpAudioFile = "tmpAudio.mp3";
		double dRate = Double.parseDouble(rate);
		long secondOfAudio = (long) ((double) index / dRate);
		secondOfAudio += 2;
		String endTime = milliSecondToTime(secondOfAudio * 1000);
		String[] cutAudioCmd = { ffmpegPath, "-y", "-i", audioFile, "-ss", "0:0:0", "-to", endTime, "-c", "copy",
				tmpAudioFile };
		ExecuteCommand.executeCommand(cutAudioCmd, null, new File("."), null);

		// Combine silent video and audio to a final video
		String[] cmds = { ffmpegPath, "-y", "-i", subtitle_video_name, "-i", tmpAudioFile, final_video_name };
		boolean bRunScript = ExecuteCommand.executeCommand(cmds, null, new File("."), null);
		return bRunScript;
	}

	private static void initMap(JSONObject requestObj) {
		Iterator<String> keys = requestObj.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			if (key.equalsIgnoreCase("superObjects")) {
				JSONArray objectsArray = (JSONArray) requestObj.get(key);
				for (Object object : objectsArray) {
					if (!(object instanceof JSONObject)) {
						continue;
					}
					JSONObject superObj = (JSONObject) object;
					supperObjectsMapList.add(superObj.toMap());
				}
			}
		}
	}

	private static List<JSONObject> getSuperObjectsByframeNumber(int num) {
		List<JSONObject> superObjects = new ArrayList<JSONObject>();
		for (Map<String, Object> map : supperObjectsMapList) {
			JSONObject jsonObj = new JSONObject(map);
			String rangeValue = jsonObj.getString("frameRange");
			String rangeArray[] = rangeValue.split(",");
			String s = rangeArray[0].substring(1);
			String e = rangeArray[1].substring(0, rangeArray[1].length() - 1);
			int sf = Integer.parseInt(s);
			int ef = Integer.parseInt(e);
			System.out.println(sf + "," + ef);
			if (num >= sf && num <= ef) {
				superObjects.add(jsonObj);
			}
		}
		return superObjects;
	}

	private static void drawSupperObjects(JSONObject jObj, Graphics2D gp2d, int number) {
		String type = jObj.getString("type");

		JSONObject attributeObj = jObj.getJSONObject("attribute");
		int x1 = attributeObj.getInt("x1");// 初始X1坐标
		int y1 = attributeObj.getInt("y1");
		int x2 = attributeObj.getInt("x2");
		int y2 = attributeObj.getInt("y2");

		String name = attributeObj.getString("name");
		float fSize = attributeObj.getFloat("size");
		if (attributeObj.has("color")) {
			String cr = attributeObj.getString("color");
			if (cr != null) {
				Color color = getColor(cr);
				gp2d.setColor(color);
			}
		}
		JSONObject actionObj = jObj.getJSONObject("action");
		String actionTrace = actionObj.getString("trace"); // 目前只按照二次函数曲线来解析 Y=aX^2+bX+c
		float step = actionObj.getFloat("step");

		String rangeValue = jObj.getString("frameRange");
		String rangeArray[] = rangeValue.split(",");
		String startFrameNumber = rangeArray[0].substring(1);
		int sfNum = Integer.parseInt(startFrameNumber);
		float X = x1 + (number - sfNum) * step;
		String parm[] = actionTrace.split("\\+");
		float a = Float.parseFloat(parm[0].substring(2, parm[0].indexOf("*")));
		float b = Float.parseFloat(parm[1].substring(0, parm[1].indexOf("*")));
		float c = Float.parseFloat(parm[2]);
		float Y = (float) (a * X * X + b * X + c);

		if (name != null && !name.trim().isEmpty()) {
			if (!"text".equalsIgnoreCase(type) && !"picture".equalsIgnoreCase(type)) {
				gp2d.drawString(name, X, Y);
			}
		}

		if ("rayline".equalsIgnoreCase(type)) {
			if (attributeObj.has("size")) {
				BasicStroke bs = new BasicStroke(fSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
				gp2d.setStroke(bs);
			}
			gp2d.drawLine((int) X, (int) Y, x2, y2);

		} else if ("line".equalsIgnoreCase(type)) {
			float XX = x2 + (number - sfNum) * step;
			float YY = (float) (a * XX * XX + b * XX + c + y2 - y1);
			if (attributeObj.has("size")) {
				BasicStroke bs = new BasicStroke(fSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
				gp2d.setStroke(bs);
			}
			gp2d.drawLine((int) X, (int) Y, (int) XX, (int) YY);

		} else if ("circle".equalsIgnoreCase(type)) {
			gp2d.fillOval((int) X, (int) Y, x2, y2);
		} else if ("rect".equalsIgnoreCase(type)) {
			gp2d.fill3DRect((int) X, (int) Y, x2, y2, false);
		} else if ("text".equalsIgnoreCase(type)) {
			Font font = new Font("黑体", Font.BOLD, (int) fSize);
			gp2d.setFont(font);
			gp2d.drawString(name, X, Y);
		} else if ("picture".equalsIgnoreCase(type)) {
			String picFile = name;
			if (actionObj.has("loop")) {
				JSONArray loopArray = actionObj.getJSONArray("loop");
				int index = (number - sfNum) % loopArray.length();
				picFile = (String) loopArray.get(index);
			}
			File imgFile = new File(picFile);
			if (imgFile.exists()) {
				Image img = null;
				try {
					img = ImageIO.read(imgFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				int w = x2;
				int h = y2;
				gp2d.drawImage(img, (int) X, (int) Y, w, h, null);
			} else {
				System.out.println("WARNING: The file " + imgFile.getName() + " doesn't exist!");
			}
		}
	}

	private static void drawGraphic(JSONObject jObj, Graphics2D gp2d) {
		String graphicType = jObj.getString("graphic");
		JSONObject attrObj = jObj.getJSONObject("attribute");
		int left = attrObj.getInt("left");
		int top = attrObj.getInt("top");
		String c = attrObj.getString("color");
		Color color = getColor(c);
		if ("line".equalsIgnoreCase(graphicType)) {
			int right = attrObj.getInt("right");
			int bottom = attrObj.getInt("bottom");
			if (attrObj.has("size")) {
				float fSize = attrObj.getFloat("size");
				BasicStroke bs = new BasicStroke(fSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
				gp2d.setStroke(bs);
			}
			gp2d.setColor(color);
			gp2d.drawLine(left, top, right, bottom);
		} else if ("circle".equalsIgnoreCase(graphicType)) {
			int width = attrObj.getInt("width");
			int height = attrObj.getInt("height");
			gp2d.setColor(color);
			gp2d.fillOval(left, top, width, height);
		} else if ("rect".equalsIgnoreCase(graphicType)) {
			int width = attrObj.getInt("width");
			int height = attrObj.getInt("height");
			gp2d.setColor(color);
			gp2d.fill3DRect(left, top, width, height, false);
		}
	}

	private static Color getColor(String color) {
		String[] colors = color.split(",");
		int red = Integer.parseInt(colors[0]);
		int green = Integer.parseInt(colors[1]);
		int blue = Integer.parseInt(colors[2]);
		return new Color(red, green, blue);
	}

	private static String milliSecondToTime(long millSecond) {
		long second = millSecond / 1000;
		second = second % 86400;
		long hours = second / 3600;
		second = second % 3600;
		long minutes = second / 60;
		second = second % 60;
		String s = String.format("%01d:%01d:%01d", hours, minutes, second);
		return s;
	}

	private static JSONObject getJsonObjectbyName(JSONObject jsonObj, String name) {
		if (jsonObj == null) {
			return null;
		}
		String[] names = JSONObject.getNames(jsonObj);
		if (names == null) {
			return null;
		}
		for (String s : names) {
			if (s.equalsIgnoreCase(name)) {
				return jsonObj.getJSONObject(s);
			}
		}
		return null;
	}

}
