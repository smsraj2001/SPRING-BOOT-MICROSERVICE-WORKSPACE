package com.tvsmotor.contoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tvsmotor.entity.Stock;
import com.tvsmotor.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }
}
