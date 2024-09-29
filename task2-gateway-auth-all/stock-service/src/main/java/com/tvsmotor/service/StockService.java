package com.tvsmotor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvsmotor.entity.Stock;
import com.tvsmotor.repository.StockRepository;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow();
    }
}