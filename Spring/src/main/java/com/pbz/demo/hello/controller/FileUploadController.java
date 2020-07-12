package com.pbz.demo.hello.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		if (myfile.getSize() > 1024 * 1024 * 100) {
			resMap.put("code", 500);
			resMap.put("message", "文件过大，请上传100M以内的图片");
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

	@PostMapping(value = "/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String saveJson2File(@RequestParam(name = "filename") String filename, @RequestBody String jsonString)
			throws Exception {
		jsonString = URLDecoder.decode(jsonString, "UTF-8");

		String file = System.getProperty("user.dir") + "/" + filename;
		OutputStreamWriter ops = null;
		ops = new OutputStreamWriter(new FileOutputStream(file));
		if (!jsonString.startsWith("{") && !jsonString.endsWith("}")) {
			jsonString = jsonString.substring(1, jsonString.length() - 1);
		}
		ops.write(jsonString);
		ops.close();
		System.out.println(jsonString);
		return jsonString;
	}

	@RequestMapping("/download")
	public static Object downLoadFileToServer(@RequestParam("url") String url) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		int index = url.lastIndexOf("/");
		String fileName = "";
		if (index > 0) {
			fileName = url.substring(index + 1);
		}
		if (fileName.trim().length() == 0 || fileName.indexOf(".") == -1) {
			resMap.put("error", "The url " + url + " is not correct!");
			return resMap;
		}
		String downloadFilePath = System.getProperty("user.dir") + "/" + fileName;
		long s = System.currentTimeMillis();
		url = url.replaceAll(" ", "%20");
		URL httpUrl = new URL(url);
		FileUtils.copyURLToFile(httpUrl, new File(downloadFilePath));
		long e = System.currentTimeMillis();
		resMap.put("code", 200);
		resMap.put("message", "文件下载成功, 花费时间:" + (e - s) + "ms");
		resMap.put("filename", fileName);
		resMap.put("pathOnServer", downloadFilePath);

		return resMap;
	}
	
	@RequestMapping("/getResourceOnServer")
	public static Object uploadFil11e(@RequestParam(name = "format") String format) {
		Map<String, Object> responseMap = new HashMap<String, Object>();

		List<String> list = new ArrayList<String>();
		String curDir = System.getProperty("user.dir");
		File f = new File(curDir);
		File[] fs = f.listFiles();
		for (int i = 0; i < fs.length; ++i) {
			File file = fs[i];
			String name = file.getName();
			if (name.endsWith(format)) {
				list.add(name);
			}
		}
		responseMap.put("resource", list);
		return responseMap;
	}

}