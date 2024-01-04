package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HRPolicyService {

    @Autowired
    private HRPolicyRepo hrPolicyRepository;

    public List<HRPolicy> getAllHrPolicies() {
        return hrPolicyRepository.findAll();
    }

    public Optional<HRPolicy> getHrPolicyById(long policyId) {
        return hrPolicyRepository.findById(policyId);
    }

    public HRPolicy createHrPolicy(HRPolicy hrPolicy) {
        // In a real application, you might add validation or other business logic
        return hrPolicyRepository.save(hrPolicy);
    }

    public HRPolicy updateHrPolicy(long policyId, HRPolicy updatedHrPolicy) {
        Optional<HRPolicy> optionalHrPolicy = hrPolicyRepository.findById(policyId);
        if (optionalHrPolicy.isPresent()) {
            HRPolicy hrPolicy = optionalHrPolicy.get();
            hrPolicy.setPolicyName(updatedHrPolicy.getPolicyName());
            hrPolicy.setPolicyDetails(updatedHrPolicy.getPolicyDetails());
            return hrPolicyRepository.save(hrPolicy);
        }
        return null; // Handle not found scenario
    }

    public void deleteHrPolicy(long policyId) {
        hrPolicyRepository.deleteById(policyId);
    }
}

