package com.tvsmotor.dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class VehicleDto {
	private int id;
	private String name;
	private int price;
	private int mileage;
	private String type;
	private LocalDate manufacturingDate;

}
