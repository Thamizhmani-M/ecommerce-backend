package com.ecommerce.ecommerce_backend.model;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String role;
}