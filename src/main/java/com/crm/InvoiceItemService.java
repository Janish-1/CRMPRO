package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemService {

    @Autowired
    private InvoiceItemRepo invoiceItemRepository;

    public List<InvoiceItem> getAllInvoiceItems() {
        return invoiceItemRepository.findAll();
    }

    public Optional<InvoiceItem> getInvoiceItemById(Long id) {
        return invoiceItemRepository.findById(id);
    }

    public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem) {
        // In a real application, you might add validation or other business logic
        return invoiceItemRepository.save(invoiceItem);
    }

    public InvoiceItem updateInvoiceItem(Long id, InvoiceItem updatedInvoiceItem) {
        Optional<InvoiceItem> optionalInvoiceItem = invoiceItemRepository.findById(id);
        if (optionalInvoiceItem.isPresent()) {
            InvoiceItem invoiceItem = optionalInvoiceItem.get();
            invoiceItem.setServiceId(updatedInvoiceItem.getServiceId());
            invoiceItem.setServiceName(updatedInvoiceItem.getServiceName());
            invoiceItem.setPrice(updatedInvoiceItem.getPrice());
            invoiceItem.setQuantity(updatedInvoiceItem.getQuantity());
            return invoiceItemRepository.save(invoiceItem);
        }
        return null; // Handle not found scenario
    }

    public void deleteInvoiceItem(Long id) {
        invoiceItemRepository.deleteById(id);
    }
}


