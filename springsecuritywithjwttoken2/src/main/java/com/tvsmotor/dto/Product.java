package com.tvsmotor.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	double price;
	String category;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, double price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}
}
