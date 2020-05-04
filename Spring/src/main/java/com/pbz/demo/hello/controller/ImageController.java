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

import com.pbz.demo.hello.service.ClockImageService;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

	@Autowired
	private ClockImageService clockImageService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	private static int IMAGE_WIDTH = 450;
	private static int IMAGE_HEIGHT = 390;

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