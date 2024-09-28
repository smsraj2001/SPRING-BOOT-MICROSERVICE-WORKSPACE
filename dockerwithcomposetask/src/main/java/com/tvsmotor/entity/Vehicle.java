package com.tvsmotor.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle {
	
@Id
private String _id;
private String name;
private int price;


public Vehicle() {
	super();
}


public Vehicle(String _id, String name, int price) {
	super();
	this._id = _id;
	this.name = name;
	this.price = price;
}


public String get_id() {
	return _id;
}


public void set_id(String _id) {
	this._id = _id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}





}
