package com.tvsmotor.service;

import java.util.List;

import com.tvsmotor.dto.VehicleDto;

public interface VehicleInterface {
    VehicleDto addVehicle(VehicleDto vehicleDto);
    List<VehicleDto> viewAllVehicle();
    VehicleDto viewVehicleById(int id);
    VehicleDto updateVehicleById(int id, VehicleDto vehicleDto);
    String deleteVehicleById(int id);
}
