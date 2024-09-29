package com.tvsmotor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle-service")
public interface VehicleFeignClient {
    @GetMapping("/vehicle/{id}")
    VehicleFeignClient getVehicleById(@PathVariable("id") Long id);
}
