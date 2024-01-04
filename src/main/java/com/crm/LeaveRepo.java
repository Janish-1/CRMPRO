package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepo extends JpaRepository<Leave, Long> {
    // Additional methods if needed
}

