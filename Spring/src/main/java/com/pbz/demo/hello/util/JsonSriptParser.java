package com.pbz.demo.hello.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;

public final class JsonSriptParser {
	private static final String subtitle_video_name = "vSubtitle.mp4";
	private static final String final_video_name = "vFinal.mp4";
	private static final boolean isWindows = System.getProperty("os.name").startsWith("Windows");

	public static boolean generateVideoByScriptFile(String scriptFilePath) throws Exception {
		String jsonString = new String(Files.readAllBytes(new File(scriptFilePath).toPath()));
		return generateVideo(jsonString);
	}

	private static boolean generateVideo(String jsonString) throws Exception {
		JSONObject jsonObj = new JSONObject(jsonString);
		JSONObject requestObj = getJsonObjectbyName(jsonObj, "request");

		String version = requestObj.getString("version");
		System.out.println("剧本版本:" + version);
		int width = requestObj.getInt("width");
		int height = requestObj.getInt("height");
		String audioFile = requestObj.getString("music");
		String rate = requestObj.getString("rate");

		Iterator<String> keys = requestObj.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			if (key.equalsIgnoreCase("frames")) {
				JSONArray frameArray = (JSONArray) requestObj.get(key);
				int index = 0;
				for (Object frame : frameArray) {
					if (!(frame instanceof JSONObject)) {
						continue;
					}
					JSONObject frameObj = (JSONObject) frame;
					int times = frameObj.getInt("time");
					Color colorBackground = null;
					if (frameObj.has("backgroundColor")) {
						String color = frameObj.getString("backgroundColor");
						String[] colors = color.split(",");
						int red = Integer.parseInt(colors[0]);
						int green = Integer.parseInt(colors[1]);
						int blue = Integer.parseInt(colors[2]);
						colorBackground = new Color(red, green, blue);
					}
					Image bgImg = null;
					if (frameObj.has("backgroundPicture")) {
						String srcImageFile = frameObj.getString("backgroundPicture");
						File img = new File(srcImageFile);
						bgImg = ImageIO.read(img);
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
						g.setColor(new Color(0, 0, 0));
						g.setFont(new Font("黑体", Font.BOLD, 30));
						g.drawString(Integer.toString(index + 1), width - 50, 50);// 显示帧号
						JSONArray objectArray = frameObj.getJSONArray("objects");
						for (Object object : objectArray) {
							JSONObject obj = (JSONObject) object;
							String text = obj.getString("text");
							int x = obj.getInt("x");
							int y = obj.getInt("y");
							int size = obj.getInt("size");
							String c = obj.getString("color");
							String[] co = c.split(",");
							int r = Integer.parseInt(co[0]);
							int gr = Integer.parseInt(co[1]);
							int b = Integer.parseInt(co[2]);
							System.out.println(text);
							g.setColor(new Color(r, gr, b));
							Font font = new Font("黑体", Font.BOLD, size);
							g.setFont(font);
							g.drawString(text, x, y);
						}
						g.dispose();
						ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));
						index++;
					}
				}
			}
		}
		String suffix = isWindows ? ".bat" : ".sh";
		String cmd = System.getProperty("user.dir") + "/" + "jpg2video" + suffix;
		String[] args = { "360", rate };
		ExecuteCommand.executeCommand(cmd, args);
		String ffmpegPath = "ffmpeg";
		if (!isWindows) {
			ffmpegPath = "/usr/bin/ffmpeg";
			if (!new File(ffmpegPath).exists()) {
				ffmpegPath = "/usr/local/bin/ffmpeg";
			}
		}
		String[] cmds = { ffmpegPath, "-y", "-i", subtitle_video_name, "-i", audioFile, final_video_name };
		boolean bRunScript = ExecuteCommand.executeCommand(cmds, null, new File("."), null);
		return bRunScript;
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
