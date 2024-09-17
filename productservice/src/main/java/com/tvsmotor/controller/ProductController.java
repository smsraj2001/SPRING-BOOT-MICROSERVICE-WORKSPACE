package com.tvsmotor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvsmotor.entity.Product;
import com.tvsmotor.repository.ProductRepository;

@RestController
@RequestMapping("/api/pro")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product)
	{
		return productRepository.save(product);
	}
	
	@GetMapping("/product")
	public List<Product> viewAllProduct()
	{
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}/{quantity}")
	public double getTotalAmount(@PathVariable String id, @PathVariable int quantity)
	{
		return productRepository.findById(id).get().getPrice() * quantity;
	}
	
}
