package com.tvsmotor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tvsmotor.dto.Product;

@Service
public class ProductService {
	List<Product> products = new ArrayList<Product>();
	
	public ProductService()
	{
		products.add(new Product(1, "laptop", 45000, "electronics"));	
		products.add(new Product(2, "keyboard", 3000, "electronics"));		
		products.add(new Product(3, "pendrive", 1000, "electronics"));
	}
	
	public List<Product> getAllProducts()
	{
		return products;		
	}

}
