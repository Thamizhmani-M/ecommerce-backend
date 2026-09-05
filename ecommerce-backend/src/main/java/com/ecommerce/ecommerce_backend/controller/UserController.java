package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.User;
import com.ecommerce.ecommerce_backend.repository.UserRepository;
import com.ecommerce.ecommerce_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Signup / Register API: POST http://localhost:8080/api/users/register
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Login API: POST http://localhost:8080/api/users/login
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findAll();
    }


}
