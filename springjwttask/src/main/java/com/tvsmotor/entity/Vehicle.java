package com.tvsmotor.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="vehicle30")
@Data
public class Vehicle {
	
	@Id
	private int id;
	private String name;
	private int price;
	private int mileage;
	private String type;
	private LocalDate manufacturingDate;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private boolean isDeleted;
}
