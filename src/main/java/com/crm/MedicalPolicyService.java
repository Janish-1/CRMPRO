package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalPolicyService {

    @Autowired
    private MedicalPolicyRepo medicalPolicyRepository;

    public List<MedicalPolicy> getAllMedicalPolicies() {
        return medicalPolicyRepository.findAll();
    }

    public Optional<MedicalPolicy> getMedicalPolicyById(long policyId) {
        return medicalPolicyRepository.findById(policyId);
    }

    public MedicalPolicy createMedicalPolicy(MedicalPolicy medicalPolicy) {
        // In a real application, you might add validation or other business logic
        return medicalPolicyRepository.save(medicalPolicy);
    }

    public MedicalPolicy updateMedicalPolicy(long policyId, MedicalPolicy updatedMedicalPolicy) {
        Optional<MedicalPolicy> optionalMedicalPolicy = medicalPolicyRepository.findById(policyId);
        if (optionalMedicalPolicy.isPresent()) {
            MedicalPolicy medicalPolicy = optionalMedicalPolicy.get();
            medicalPolicy.setPolicyName(updatedMedicalPolicy.getPolicyName());
            medicalPolicy.setCoverageDetails(updatedMedicalPolicy.getCoverageDetails());
            medicalPolicy.setEligibilityCriteria(updatedMedicalPolicy.getEligibilityCriteria());
            return medicalPolicyRepository.save(medicalPolicy);
        }
        return null; // Handle not found scenario
    }

    public void deleteMedicalPolicy(long policyId) {
        medicalPolicyRepository.deleteById(policyId);
    }
}

