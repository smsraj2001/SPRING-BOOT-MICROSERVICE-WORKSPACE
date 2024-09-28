package com.tvsmotor.controller;

import com.tvsmotor.entity.Vehicle;
import com.tvsmotor.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    // Create or Update Vehicle
    @PostMapping("/post")
    public Vehicle addOrUpdateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }
    // Get all vehicles
    @GetMapping("/get")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
    // Get vehicle by ID
    @GetMapping("/get/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable String id) {
        return vehicleService.getVehicleById(id);
    }
    // Update vehicle by ID
    @PutMapping("/put/{id}")
    public Vehicle updateVehicle(@PathVariable String id, @RequestBody Vehicle updatedVehicle) {
        Optional<Vehicle> vehicleOpt = vehicleService.getVehicleById(id);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            vehicle.setMake(updatedVehicle.getMake());
            vehicle.setModel(updatedVehicle.getModel());
            vehicle.setYear(updatedVehicle.getYear());
            vehicle.setColor(updatedVehicle.getColor());
            return vehicleService.saveVehicle(vehicle);
        }
        return null;  // Handle vehicle not found case
    }
    // Delete vehicle by ID
    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
    }
}