package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Cart;
import com.ecommerce.ecommerce_backend.model.CartItem;
import com.ecommerce.ecommerce_backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByEmail(String userEmail) {
        return cartRepository.findByUserEmail(userEmail).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUserEmail(userEmail);
            return cartRepository.save(newCart);
        });
    }

    public Cart addToCart(String userEmail, CartItem newItem) {
        Cart cart = getCartByEmail(userEmail);

        boolean itemExists = false;
        for (CartItem item : cart.getItems()) {
            // Null check add panrom
            if (item.getProductId() != null && item.getProductId().equals(newItem.getProductId())) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            cart.getItems().add(newItem);
        }

        return cartRepository.save(cart);
    }

    public Cart removeItemFromCart(String userEmail, Long productId) {
        Cart cart = cartRepository.findByUserEmail(userEmail).orElse(null);
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getProductId().equals(productId));
            return cartRepository.save(cart);
        }
        return null;
    }

    public Cart updateCartItemQuantity(String userEmail, Long productId, int quantity) {
        Cart cart = cartRepository.findByUserEmail(userEmail).orElse(null);
        if (cart != null) {
            for (CartItem item : cart.getItems()) {
                if (item.getProductId() != null && item.getProductId().equals(productId)) {
                    item.setQuantity(quantity);
                    break;
                }
            }
            return cartRepository.save(cart);
        }
        return null;
    }
}