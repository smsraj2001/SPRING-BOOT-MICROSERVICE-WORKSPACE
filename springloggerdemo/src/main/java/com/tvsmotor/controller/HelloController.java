package com.tvsmotor.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RequestMapping("/api/v1")
@RestController
public class HelloController {
	
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/greet")
	public String greet()
	{
//		System.out.println("---Inside Greet---");
		logger.warn("This is warning message...");
		logger.info("This is info message...");
		logger.error("This is error message...");
		logger.debug("This is debug message...");
		return "Hello World";
	}
}
