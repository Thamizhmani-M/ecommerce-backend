package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.OrderEntity;
import com.ecommerce.ecommerce_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place Order API: POST http://localhost:8080/api/orders/place
    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        return orderService.placeOrder(order);
    }

        @PostMapping("/checkout/{email}")
        public OrderEntity checkout(@PathVariable String email) {
            return orderService.checkout(email);
        }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<OrderEntity>> getUserOrders(@PathVariable String email) {
        List<OrderEntity> orders = orderService.getOrdersByUserEmail(email);
        return ResponseEntity.ok(orders);
    }

}
