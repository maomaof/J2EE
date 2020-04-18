package com.pbz.demo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class HelloApplication {
	@RequestMapping("/")
	String home() {
		return "Hello JeremyJia!";
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);
	}

}