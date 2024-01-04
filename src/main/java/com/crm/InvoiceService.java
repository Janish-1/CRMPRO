package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public Invoice createInvoice(Invoice invoice) {
        // In a real application, you might add validation or other business logic
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();
            invoice.setInvoiceId(updatedInvoice.getInvoiceId());
            invoice.setInvoiceDate(updatedInvoice.getInvoiceDate());
            invoice.setCustomerId(updatedInvoice.getCustomerId());
            invoice.setInvoiceItems(updatedInvoice.getInvoiceItems());
            invoice.setTotalAmount(updatedInvoice.getTotalAmount());
            invoice.setStatus(updatedInvoice.getStatus());
            return invoiceRepository.save(invoice);
        }
        return null; // Handle not found scenario
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
