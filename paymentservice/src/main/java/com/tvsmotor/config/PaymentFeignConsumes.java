package com.tvsmotor.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productservice")
public interface PaymentFeignConsumes {
    @GetMapping("api/pro/product/{id}/{quantity}")
    double getTotalAmount(@PathVariable String id, @PathVariable int quantity);
}
