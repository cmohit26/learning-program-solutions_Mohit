package com.cognizant.orm_learn_microservices_3.controller;

import com.cognizant.orm_learn_microservices_3.entities.Order;
import com.cognizant.orm_learn_microservices_3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Order> createUser(@RequestBody Order order) {
        return ResponseEntity.ok(service.createUser(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUser(id));
    }
}

