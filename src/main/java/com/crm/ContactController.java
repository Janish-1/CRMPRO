package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{contactId}")
    public Optional<Contact> getContactById(@PathVariable long contactId) {
        return contactService.getContactById(contactId);
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping("/{contactId}")
    public Contact updateContact(@PathVariable long contactId, @RequestBody Contact updatedContact) {
        return contactService.updateContact(contactId, updatedContact);
    }

    @DeleteMapping("/{contactId}")
    public void deleteContact(@PathVariable long contactId) {
        contactService.deleteContact(contactId);
    }
}

