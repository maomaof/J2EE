package com.pbz.demo.hello;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pbz.demo.hello.util.FileUtil;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class HelloApplication {
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("homepage.html");
		return mv;
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);

		// Copy resource files to current directory.
		String applicationDir = System.getProperty("user.dir");
		String rescourceFolder = applicationDir + "/" + "script";
		if (!new File(rescourceFolder).exists()) {
			rescourceFolder = applicationDir + "/" + "../script";
			if (!new File(rescourceFolder).exists()) {
				rescourceFolder = "";
			}
		}
		if (rescourceFolder != "") {
			System.out.println("Copy resource files");
			FileUtil.copyDirectory(new File(rescourceFolder), new File(applicationDir));
			boolean isWindows = System.getProperty("os.name").startsWith("Windows");
			if (!isWindows) {
				String scriptPath = applicationDir + "/" + "jpg2video.sh";
				FileUtil.chmod("755 " + scriptPath);
				System.out.println("Chmod file " + scriptPath);
			}
		}

	}

}