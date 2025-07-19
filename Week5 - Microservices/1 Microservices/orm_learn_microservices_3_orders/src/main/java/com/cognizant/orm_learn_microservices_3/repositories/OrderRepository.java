package com.cognizant.orm_learn_microservices_3.repositories;

import com.cognizant.orm_learn_microservices_3.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
