package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
    // Custom queries or methods can be added if needed
}

