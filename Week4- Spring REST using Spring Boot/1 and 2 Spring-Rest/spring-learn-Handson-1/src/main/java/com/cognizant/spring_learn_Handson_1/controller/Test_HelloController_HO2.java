package com.cognizant.spring_learn_Handson_1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test_HelloController_HO2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test_HelloController_HO2.class);

    @GetMapping("/hello/test1")
    public ResponseEntity<String> sayHello1() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/hello/test2")
    public String sayHello2() {
        LOGGER.info("START - sayHello()");
        String response = "Hello World!!";
        LOGGER.info("END - sayHello()");
        return response;
    }

}
