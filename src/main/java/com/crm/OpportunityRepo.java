package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityRepo extends JpaRepository<Opportunity, Long> {
    // Additional methods if needed
}

