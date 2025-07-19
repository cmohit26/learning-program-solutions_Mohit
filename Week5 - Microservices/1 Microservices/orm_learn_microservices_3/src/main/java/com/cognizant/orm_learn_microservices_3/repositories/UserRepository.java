package com.cognizant.orm_learn_microservices_3.repositories;

import com.cognizant.orm_learn_microservices_3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
