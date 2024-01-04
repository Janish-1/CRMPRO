package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(long customerId) {
        return customerRepository.findById(customerId);
    }

    public void createCustomer(Customer customer) {
        // In a real application, you might add validation or other business logic
        customerRepository.save(customer);
    }

    public void updateCustomer(long customerId, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            customerRepository.save(customer);
        }
    }

    public void deleteCustomer(long customerId) {
        customerRepository.deleteById(customerId);
    }
}

