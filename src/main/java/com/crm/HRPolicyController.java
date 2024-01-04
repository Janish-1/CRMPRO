package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hr-policies")
public class HRPolicyController {

    @Autowired
    private HRPolicyService hrPolicyService;

    @GetMapping
    public List<HRPolicy> getAllHrPolicies() {
        return hrPolicyService.getAllHrPolicies();
    }

    @GetMapping("/{policyId}")
    public Optional<HRPolicy> getHrPolicyById(@PathVariable long policyId) {
        return hrPolicyService.getHrPolicyById(policyId);
    }

    @PostMapping
    public HRPolicy createHrPolicy(@RequestBody HRPolicy hrPolicy) {
        return hrPolicyService.createHrPolicy(hrPolicy);
    }

    @PutMapping("/{policyId}")
    public HRPolicy updateHrPolicy(@PathVariable long policyId, @RequestBody HRPolicy updatedHrPolicy) {
        return hrPolicyService.updateHrPolicy(policyId, updatedHrPolicy);
    }

    @DeleteMapping("/{policyId}")
    public void deleteHrPolicy(@PathVariable long policyId) {
        hrPolicyService.deleteHrPolicy(policyId);
    }
}

