package com.ecommerce.ecommerce_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private double totalAmount;
    private String orderStatus;

    @ElementCollection
    private List<String> productsSummary;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public List<String> getProductsSummary() { return productsSummary; }
    public void setProductsSummary(List<String> productsSummary) { this.productsSummary = productsSummary; }
}