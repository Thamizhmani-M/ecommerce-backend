package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    // User Email to fetch the orders in the method
    List<OrderEntity> findByUserEmail(String userEmail);
}
