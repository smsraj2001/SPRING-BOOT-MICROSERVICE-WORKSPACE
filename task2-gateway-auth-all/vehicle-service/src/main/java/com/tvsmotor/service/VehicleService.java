package com.tvsmotor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvsmotor.entity.Vehicle;
import com.tvsmotor.repository.VehicleRepository;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> viewAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();
        vehicle.setName(vehicleDetails.getName());
        vehicle.setType(vehicleDetails.getType());
        vehicle.setYear(vehicleDetails.getYear());
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
