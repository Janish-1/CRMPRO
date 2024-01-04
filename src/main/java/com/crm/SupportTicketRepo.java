package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportTicketRepo extends JpaRepository<SupportTicket, Long> {
    // Additional methods if needed
}

