package com.tvsmotor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvsmotor.entity.Vehicle;
import com.tvsmotor.repository.VehicleRepository;

@RestController
@RequestMapping("/api/veh")
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping("/vehicles")
	public List<Vehicle> viewAllVehicle()
	{
		return vehicleRepository.findAll();
	}

	@PostMapping("/vehicles")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle)
	{
		return vehicleRepository.save(vehicle);
	}
	
	@DeleteMapping("/vehicles/{id}")
	public void deleteVehicleById(@PathVariable String id )
	{
		vehicleRepository.deleteById(id);
	}

	@GetMapping("/vehicle/{id}")
	public double calculatePrice(@PathVariable String id)
	{
		Vehicle veh=vehicleRepository.findById(id).get();
		return veh.getPrice();
	}
	
}
