package com.tvsmotor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvsmotor.entity.Vehicle;
import com.tvsmotor.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;
@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    // Create or Vehicle
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    // Get vehicle by ID
    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleRepository.findById(id);
    }
    // Delete vehicle by ID
    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);
    }
}