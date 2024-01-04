package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(long contactId) {
        return contactRepository.findById(contactId);
    }

    public Contact createContact(Contact contact) {
        // In a real application, you might add validation or other business logic
        return contactRepository.save(contact);
    }

    public Contact updateContact(long contactId, Contact updatedContact) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setName(updatedContact.getName());
            contact.setPhoneNumber(updatedContact.getPhoneNumber());
            return contactRepository.save(contact);
        }
        return null; // Handle not found scenario
    }

    public void deleteContact(long contactId) {
        contactRepository.deleteById(contactId);
    }
}

