package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalPolicyRepo extends JpaRepository<MedicalPolicy, Long> {
    // Additional methods if needed
}
