package com.tvsmotor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class LoginController {
	@GetMapping("/username")
	public String getUserName()
	{
		return "Your name is Sachin";
	}
	
	@GetMapping("/email")
	public String getEmail()
	{
		return "Your Email is Raj@tvsmotor.com";
	}

}
