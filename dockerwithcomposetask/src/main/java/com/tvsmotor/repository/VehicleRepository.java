package com.tvsmotor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvsmotor.entity.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {

}
