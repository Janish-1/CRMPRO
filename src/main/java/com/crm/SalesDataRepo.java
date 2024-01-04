package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesDataRepo extends JpaRepository<SalesData, Long> {
    // Additional methods if needed
}
