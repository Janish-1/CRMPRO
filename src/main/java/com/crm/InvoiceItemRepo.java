package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepo extends JpaRepository<InvoiceItem, Long> {
    // Additional methods if needed
}


