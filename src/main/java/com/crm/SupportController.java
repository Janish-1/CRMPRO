package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/support")
public class SupportController {

    @Autowired
    private SupportService supportService;

    @GetMapping
    public List<Support> getAllSupportDetails() {
        return supportService.getAllSupportDetails();
    }

    @GetMapping("/{customerId}")
    public Optional<Support> getSupportDetailsById(@PathVariable long customerId) {
        return supportService.getSupportDetailsById(customerId);
    }

    @PostMapping
    public void createSupportDetails(@RequestBody Support support) {
        supportService.createSupportDetails(support);
    }

    @PutMapping("/{customerId}")
    public void updateSupportDetails(@PathVariable long customerId, @RequestBody Support updatedSupport) {
        supportService.updateSupportDetails(customerId, updatedSupport);
    }

    @DeleteMapping("/{customerId}")
    public void deleteSupportDetails(@PathVariable long customerId) {
        supportService.deleteSupportDetails(customerId);
    }
}

