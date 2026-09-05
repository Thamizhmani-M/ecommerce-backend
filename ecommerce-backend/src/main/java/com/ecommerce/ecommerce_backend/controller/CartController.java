package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Cart;
import com.ecommerce.ecommerce_backend.model.CartItem;
import com.ecommerce.ecommerce_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Get Cart by User Email
    @GetMapping("/{email}")
    public Cart getCart(@PathVariable String email) {
        return cartService.getCartByEmail(email);
    }

    // Add Item to Cart
    @PostMapping("/add/{email}")
    public Cart addToCart(@PathVariable String email, @RequestBody CartItem cartItem) {
        return cartService.addToCart(email, cartItem);
    }

    @DeleteMapping("/remove/{email}/{productId}")
    public Cart removeItemFromCart(@PathVariable String email, @PathVariable Long productId) {
        return cartService.removeItemFromCart(email, productId);
    }

    @PutMapping("/update/{email}/{productId}/{quantity}")
    public Cart updateCartQuantity(@PathVariable String email, @PathVariable Long productId, @PathVariable int quantity) {
        return cartService.updateCartItemQuantity(email, productId, quantity);
    }


}