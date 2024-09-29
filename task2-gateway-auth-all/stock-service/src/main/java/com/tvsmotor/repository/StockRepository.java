package com.tvsmotor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvsmotor.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}