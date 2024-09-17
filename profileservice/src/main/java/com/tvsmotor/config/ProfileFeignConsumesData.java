package com.tvsmotor.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "loginservice")
public interface ProfileFeignConsumesData {
	@GetMapping("api/user/username")
	public String getUserName();
	@GetMapping("api/user/email")
	public String getEmail();
}
