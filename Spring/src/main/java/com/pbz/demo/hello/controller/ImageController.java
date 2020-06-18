package com.pbz.demo.hello.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pbz.demo.hello.service.ClockImageService;
import com.pbz.demo.hello.service.SubtitleImageService;
import com.pbz.demo.hello.util.ExecuteCommand;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

	@Autowired
	private ClockImageService clockImageService;
	@Autowired
	private SubtitleImageService subtitleImageService;

	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	private static int IMAGE_WIDTH = 450;
	private static int IMAGE_HEIGHT = 390;
	private static final boolean isWindows = System.getProperty("os.name").startsWith("Windows");

	@RequestMapping(value = "/clock")
	@ResponseBody
	public void getClockImage(@RequestParam(name = "time") String time) throws Exception {
		Object username = request.getSession().getAttribute("name");
		if (!"admin".equals(username)) {
			throw new Exception("Please login first!");
		}
		verifyParameter(time);

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 创建内存图像并获得其图形上下文
		BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		clockImageService.drawImage(g, IMAGE_WIDTH, IMAGE_HEIGHT, time);
		g.dispose();

		// 将图像输出到客户端
		ServletOutputStream sos = response.getOutputStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, "JPEG", bos);
		byte[] buf = bos.toByteArray();
		response.setContentLength(buf.length);
		sos.write(buf);
		bos.close();
		sos.close();
	}

	@RequestMapping(value = "/subtitle")
	@ResponseBody
	public String saveSubtitleImages(@RequestParam(name = "filename") String filename) throws Exception {

		String filePath = System.getProperty("user.dir") + "/" + filename;// "1.srt";
		System.out.println(filePath);
		int number = subtitleImageService.saveSubtitleToImageFile(filePath, 768, 512);
		String strResult = "解析字幕文件错误!";
		if (number > 0) {
			strResult = "字幕文件解析成功，已在服务器端生成字幕图片，访问http://localhost:8080/NumberOfPicture.jpg查看图片，生成的图片总数:" + number;
			String command = System.getProperty("user.dir") + "/" + "jpg2video";
			String[] args = { "360" };
			if (isWindows) {
				command += ".bat";
			} else {
				command += ".sh";
			}
			boolean bRunScript = ExecuteCommand.executeCommand(command, args);
			if (bRunScript) {
				strResult += ". \"jpg2video\"脚本调用成功！已合成MP4，访问http://localhost:8080/vSubtitle.mp4查看视频";
			}
		}
		return strResult;

	}

	@RequestMapping(value = "/combine")
	public ModelAndView combineSubtiteAndVideo2MP4(@RequestParam(name = "subtitlefile") String subtitleFile,
			@RequestParam(name = "audiofile") String audioFile) throws Exception {
		ModelAndView mv = new ModelAndView();
		String path = System.getProperty("user.dir") + "/" + subtitleFile;
		int number = subtitleImageService.saveSubtitleToImageFile(path, 800, 600);
		// String strResult = "将字幕文件与音频文件合成视频文件出错！";
		if (number > 0) {
			String suffix = isWindows ? ".bat" : ".sh";
			String cmd1 = System.getProperty("user.dir") + "/" + "jpg2video" + suffix;
			String[] args1 = { "360" };
			ExecuteCommand.executeCommand(cmd1, args1);
			String cmd2 = "ffmpeg";
			String[] args2 = { "-y", "-i", "vSubtitle.mp4", "-i", "1.mp3", "final.mp4" };
			boolean b = ExecuteCommand.executeCommand(cmd2, args2);
			if (b) {
				// strResult = "已为您合成视频文件，访问http://localhost:8080/final.mp4";
				mv.setViewName("video.html");
				mv.addObject("message", "OK");
			}
		}
		return mv;
	}

	private void verifyParameter(String time) throws Exception {
		if (time == null || time.trim().length() == 0) {
			throw new Exception("The time parameter is not specified.");
		}
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			format.setLenient(false);// 此处指定日期/时间解析是否严格，true是不严格，false为严格
			format.parse(time);
		} catch (ParseException e) {
			throw new Exception("The format of time parameter is invalid! " + e.getMessage());
		}
	}

}