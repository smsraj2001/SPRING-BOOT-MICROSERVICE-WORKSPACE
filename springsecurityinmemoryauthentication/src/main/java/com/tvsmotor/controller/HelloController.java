package com.tvsmotor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class HelloController {
	
	@GetMapping("/home")
	public String home()
	{
		return "This is home. Anyone can access without login.";
	}
	
	@GetMapping("/admin/addproduct")
	public String adminUser()
	{
		return "Only admin can access this, to add the product.";
	}
	
	@GetMapping("/admin/editproduct")
	public String adminUser2()
	{
		return "Only admin can access this, to edit the product.";
	}
	
	@GetMapping("/user/viewproduct")
	public String customer()
	{
		return "Only user can access this api.";
	}
	
	@GetMapping("/contact")
	public String contact()
	{
		return "Both types of user can access this api.";
	}
}