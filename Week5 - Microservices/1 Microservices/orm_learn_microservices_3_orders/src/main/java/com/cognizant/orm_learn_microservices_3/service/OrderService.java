package com.cognizant.orm_learn_microservices_3.service;


import com.cognizant.orm_learn_microservices_3.entities.Order;
import com.cognizant.orm_learn_microservices_3.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order createUser(Order order) {
        return repository.save(order);
    }

    public Order getUser(Long id) {
        return repository.findById(id).orElseThrow();
    }

}

