package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepo supportTicketRepository;

    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketRepository.findAll();
    }

    public Optional<SupportTicket> getSupportTicketById(Long ticketId) {
        return supportTicketRepository.findById(ticketId);
    }

    public void createSupportTicket(SupportTicket supportTicket) {
        // In a real application, you might add validation or other business logic
        supportTicketRepository.save(supportTicket);
    }

    public void resolveSupportTicket(Long ticketId) {
        Optional<SupportTicket> optionalSupportTicket = supportTicketRepository.findById(ticketId);
        if (optionalSupportTicket.isPresent()) {
            SupportTicket supportTicket = optionalSupportTicket.get();
            supportTicket.setResolved(true);
            supportTicketRepository.save(supportTicket);
        }
    }
}

