package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Cart;
import com.ecommerce.ecommerce_backend.model.CartItem;
import com.ecommerce.ecommerce_backend.model.OrderEntity;
import com.ecommerce.ecommerce_backend.repository.CartRepository;
import com.ecommerce.ecommerce_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    public OrderEntity checkout(String userEmail) {
        Cart cart = cartService.getCartByEmail(userEmail);
        if (cart == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty!");
        }

        double total = 0;
        List<String> summary = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            total += item.getPrice() * item.getQuantity();
            summary.add(item.getProductName() + " (Qty: " + item.getQuantity() + ")");
        }

        OrderEntity order = new OrderEntity();
        order.setUserEmail(userEmail);
        order.setTotalAmount(total);
        order.setOrderStatus("SUCCESS");
        order.setProductsSummary(summary);

        // Clear cart items after successful order
        cart.getItems().clear();
        cartRepository.save(cart);

        return orderRepository.save(order);
    }

    public OrderEntity placeOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    public List<OrderEntity> getOrdersByEmail(String userEmail) {
        return orderRepository.findByUserEmail(userEmail);
    }

    public List<OrderEntity> getOrdersByUserEmail(String userEmail) {
        return orderRepository.findByUserEmail(userEmail);
    }
}