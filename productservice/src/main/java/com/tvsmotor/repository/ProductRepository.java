package com.tvsmotor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tvsmotor.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>
{
	
}
