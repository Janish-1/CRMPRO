package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
    // Custom queries or methods can be added if needed
}

