package com.ecommerce.ecommerce_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String sayHello() {
        return "E-Commerce Backend is running successfully with MySQL!";
    }
}