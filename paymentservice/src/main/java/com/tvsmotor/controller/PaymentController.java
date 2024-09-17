package com.tvsmotor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tvsmotor.config.PaymentFeignConsumes;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentFeignConsumes paymentFeignConsumes;

    @GetMapping("/viewPayment/{id}/{quantity}")
    public String viewPayment(@PathVariable String id, @PathVariable int quantity) {
        double price = paymentFeignConsumes.getTotalAmount(id, quantity);
        return "The total amount is: " + price;
    }
}
