package com.tvsmotor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvsmotor.config.ProfileFeignConsumesData;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	@Autowired
	ProfileFeignConsumesData profileFeignConsumesData;
	
	@GetMapping("/viewProfile")
	public String viewProfile()
	{
		String name = profileFeignConsumesData.getUserName();
		String email = profileFeignConsumesData.getEmail();
		return "This is profile detail service. " + name + ". " + email;
	}

}
