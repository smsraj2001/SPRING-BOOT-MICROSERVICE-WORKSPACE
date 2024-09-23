package com.tvs.service;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tvs.dto.Product;
import com.tvs.entity.UserInfo;
import com.tvs.repository.UserInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = new ArrayList<Product>();
    
    public ProductService() {
    	productList.add(new Product(1, "laptop", 34, 56000));
    	productList.add(new Product(2, "mouse", 24, 7000));
    	productList.add(new Product(3, "pen", 1000, 1000));

    	
	}

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    

    public List<Product> getProducts() {
        return productList;
    }

    public Product getProduct(int id) {
        return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    }


    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}