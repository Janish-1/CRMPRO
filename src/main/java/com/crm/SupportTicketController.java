package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;

    @GetMapping
    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketService.getAllSupportTickets();
    }

    @GetMapping("/{ticketId}")
    public Optional<SupportTicket> getSupportTicketById(@PathVariable Long ticketId) {
        return supportTicketService.getSupportTicketById(ticketId);
    }

    @PostMapping
    public void createSupportTicket(@RequestBody SupportTicket supportTicket) {
        supportTicketService.createSupportTicket(supportTicket);
    }

    @PutMapping("/resolve/{ticketId}")
    public void resolveSupportTicket(@PathVariable Long ticketId) {
        supportTicketService.resolveSupportTicket(ticketId);
    }
}

