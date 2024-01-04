package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HRPolicyRepo extends JpaRepository<HRPolicy, Long> {
    // Additional methods if needed
}

