package com.tvsmotor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvsmotor.dto.Product;
import com.tvsmotor.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/viewallproducts")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "This is open url, any one can access.";
	}
}
