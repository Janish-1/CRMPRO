package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportService {

    @Autowired
    private SupportRepo supportRepository;

    public List<Support> getAllSupportDetails() {
        return supportRepository.findAll();
    }

    public Optional<Support> getSupportDetailsById(long customerId) {
        return supportRepository.findById(customerId);
    }

    public void createSupportDetails(Support support) {
        // In a real application, you might add validation or other business logic
        supportRepository.save(support);
    }

    public void updateSupportDetails(long customerId, Support updatedSupport) {
        Optional<Support> optionalSupport = supportRepository.findById(customerId);
        if (optionalSupport.isPresent()) {
            Support support = optionalSupport.get();
            support.setFirstName(updatedSupport.getFirstName());
            support.setLastName(updatedSupport.getLastName());
            support.setAge(updatedSupport.getAge());
            support.setGender(updatedSupport.getGender());
            support.setEmail(updatedSupport.getEmail());
            support.setPhoneNumber(updatedSupport.getPhoneNumber());
            support.setTotalPurchaseAmount(updatedSupport.getTotalPurchaseAmount());
            support.setTotalOrders(updatedSupport.getTotalOrders());
            supportRepository.save(support);
        }
    }

    public void deleteSupportDetails(long customerId) {
        supportRepository.deleteById(customerId);
    }
}
