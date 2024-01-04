package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepo extends JpaRepository<Performance, Long> {
    // Additional methods if needed
}

