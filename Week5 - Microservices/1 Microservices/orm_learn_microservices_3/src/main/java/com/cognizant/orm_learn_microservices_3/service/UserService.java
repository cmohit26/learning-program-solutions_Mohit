package com.cognizant.orm_learn_microservices_3.service;

import com.cognizant.orm_learn_microservices_3.entities.User;
import com.cognizant.orm_learn_microservices_3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Autowired
    private WebClient webClient;

    public Mono<User> getUserById(Long userId) {
        return webClient.get()
                .uri("/users/{id}", userId)
                .retrieve()
                .bodyToMono(User.class);
    }

}

