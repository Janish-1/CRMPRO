package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoice-items")
public class InvoiceItemController {

    @Autowired
    private InvoiceItemService invoiceItemService;

    @GetMapping
    public List<InvoiceItem> getAllInvoiceItems() {
        return invoiceItemService.getAllInvoiceItems();
    }

    @GetMapping("/{invoiceItemId}")
    public Optional<InvoiceItem> getInvoiceItemById(@PathVariable long invoiceItemId) {
        return invoiceItemService.getInvoiceItemById(invoiceItemId);
    }

    @PostMapping
    public InvoiceItem createInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
        return invoiceItemService.createInvoiceItem(invoiceItem);
    }

    @PutMapping("/{invoiceItemId}")
    public InvoiceItem updateInvoiceItem(@PathVariable long invoiceItemId, @RequestBody InvoiceItem updatedInvoiceItem) {
        return invoiceItemService.updateInvoiceItem(invoiceItemId, updatedInvoiceItem);
    }

    @DeleteMapping("/{invoiceItemId}")
    public void deleteInvoiceItem(@PathVariable long invoiceItemId) {
        invoiceItemService.deleteInvoiceItem(invoiceItemId);
    }
}

