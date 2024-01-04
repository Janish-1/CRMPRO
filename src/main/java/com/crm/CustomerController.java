package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable long customerId, @RequestBody Customer updatedCustomer) {
        customerService.updateCustomer(customerId, updatedCustomer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable long customerId) {
        customerService.deleteCustomer(customerId);
    }
}

