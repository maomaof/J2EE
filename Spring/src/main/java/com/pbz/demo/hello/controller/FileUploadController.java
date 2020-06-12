package com.pbz.demo.hello.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FileUploadController {

	@RequestMapping("/uploadpage")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload.html");
		return mv;
	}

	@RequestMapping("/upload")
	public static Object uploadFile(@RequestParam("file") MultipartFile myfile, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (myfile.getSize() > 1024 * 1024 * 10) {
			resMap.put("code", 500);
			resMap.put("message", "文件过大，请上传10M以内的图片");
			System.out.println("文件上传失败");
			return resMap;
		}
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		if (myfile != null) {
			String realPathOnServer = System.getProperty("user.dir") + "/";// e.g, Users/jjia/uploadFiles/
			if (myfile.isEmpty()) {
				resMap.put("code", 400);
				resMap.put("message", "未选择文件");
			} else {
				String originalFilename = myfile.getOriginalFilename();
				try {
					FileUtils.copyInputStreamToFile(myfile.getInputStream(),
							new File(realPathOnServer, originalFilename));
					resMap.put("code", 200);
					resMap.put("message", "上传成功");
					resMap.put("filename", originalFilename);
					resMap.put("path", basePath + "/static/image/" + originalFilename);
				} catch (IOException e) {
					resMap.put("code", 500);
					String eMsg = "文件上传失败";
					System.out.println(eMsg);
					resMap.put("message", eMsg);
					e.printStackTrace();
				}
			}
		}
		return resMap;
	}
}