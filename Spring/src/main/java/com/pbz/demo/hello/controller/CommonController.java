package com.pbz.demo.hello.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbz.demo.hello.util.ExecuteCommand;
import com.pbz.demo.hello.util.FileUtil;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class CommonController {
	private static Semaphore semaphore = new Semaphore(1);

	@RequestMapping("/command")
	@ResponseBody
	public Map<String, Object> processCommandOnServer(String[] cmd) throws Exception {
		Map<String, Object> status = new HashMap<String, Object>();
		File logFile = new File("./Cmdlog.txt");
		if (logFile.exists()) {
			logFile.delete();
		}
		logFile.createNewFile();

		ExecuteCommand.executeCommand(cmd, null, new File("."), logFile.getAbsolutePath());
		String strOut = FileUtil.readAllBytes(logFile.getAbsolutePath());
		status.put("Status", "OK!");
		status.put("Message", strOut);

		return status;
	}

	@ApiIgnore
	@RequestMapping("/api/v1/test")
	public Map<String, Object> authenticated(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("message", "call method");

		int availablePermits = semaphore.availablePermits();
		if (availablePermits > 0) {
			System.out.println("抢到资源 " + availablePermits);
		} else {
			System.out.println("资源已被占用，稍后再试");
			ret.put("message", "I am busy!");
			return ret;
		}
		try {
			// 请求占用一个资源
			semaphore.acquire(1);
			System.out.println("资源正在被使用");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release(1);// 释放一个资源
			System.out.println("-----------释放资源包----------");
		}

		return ret;
	}
}
