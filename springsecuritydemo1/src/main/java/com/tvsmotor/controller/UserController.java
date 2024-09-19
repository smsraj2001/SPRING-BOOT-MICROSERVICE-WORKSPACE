package com.tvsmotor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@GetMapping("/userinfo")
	public String displayUser()
	{
		return "This is user page.";
	}

}
