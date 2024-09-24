package com.tvsmotor.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvsmotor.dto.VehicleDto;
import com.tvsmotor.entity.Vehicle;
import com.tvsmotor.repository.VehicleRepository;

@Service
public class VehicleService implements VehicleInterface {

    @Autowired
    VehicleRepository vehicleRepository;

    // Add Vehicle
    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        return convertToDto(vehicleRepository.save(convertToEntity(vehicleDto)));
    }

    // View All Vehicles
    @Override
    public List<VehicleDto> viewAllVehicle() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isDeleted())
                vehicleDtos.add(convertToDto(vehicle));
        }
        return vehicleDtos;
    }

    // View Vehicle by ID
    @Override
    public VehicleDto viewVehicleById(int id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        if (vehicle.isDeleted()) {
            throw new RuntimeException("Vehicle has been deleted");
        }
        return convertToDto(vehicle);
    }

    // Update Vehicle by ID
    @Override
    public VehicleDto updateVehicleById(int id, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        
        // Only update the fields that are provided
        vehicle.setName(vehicleDto.getName() != null ? vehicleDto.getName() : vehicle.getName());
        vehicle.setPrice(vehicleDto.getPrice() != 0 ? vehicleDto.getPrice() : vehicle.getPrice());
        vehicle.setMileage(vehicleDto.getMileage() != 0 ? vehicleDto.getMileage() : vehicle.getMileage());
        vehicle.setType(vehicleDto.getType() != null ? vehicleDto.getType() : vehicle.getType());
        vehicle.setUpdateDate(LocalDateTime.now());
        
        return convertToDto(vehicleRepository.save(vehicle));
    }

    // Soft Delete Vehicle by ID
    @Override
    public String deleteVehicleById(int id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setDeleted(true);
        vehicleRepository.save(vehicle);
        return "Vehicle: " + id + " deleted successfully";
    }

    // Convert Entity to DTO
    private VehicleDto convertToDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setName(vehicle.getName());
        vehicleDto.setMileage(vehicle.getMileage());
        vehicleDto.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDto.setPrice(vehicle.getPrice());
        vehicleDto.setType(vehicle.getType());
        return vehicleDto;
    }

    // Convert DTO to Entity
    private Vehicle convertToEntity(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDto.getName());
        vehicle.setMileage(vehicleDto.getMileage());
        vehicle.setPrice(vehicleDto.getPrice());
        vehicle.setType(vehicleDto.getType());
        vehicle.setManufacturingDate(LocalDate.now());
        vehicle.setCreateDate(LocalDateTime.now());
        vehicle.setUpdateDate(LocalDateTime.now());
        vehicle.setDeleted(false);
        return vehicle;
    }
}
