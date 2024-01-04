package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medical-policies")
public class MedicalPolicyController {

    @Autowired
    private MedicalPolicyService medicalPolicyService;

    @GetMapping
    public List<MedicalPolicy> getAllMedicalPolicies() {
        return medicalPolicyService.getAllMedicalPolicies();
    }

    @GetMapping("/{policyId}")
    public Optional<MedicalPolicy> getMedicalPolicyById(@PathVariable long policyId) {
        return medicalPolicyService.getMedicalPolicyById(policyId);
    }

    @PostMapping
    public MedicalPolicy createMedicalPolicy(@RequestBody MedicalPolicy medicalPolicy) {
        return medicalPolicyService.createMedicalPolicy(medicalPolicy);
    }

    @PutMapping("/{policyId}")
    public MedicalPolicy updateMedicalPolicy(@PathVariable long policyId, @RequestBody MedicalPolicy updatedMedicalPolicy) {
        return medicalPolicyService.updateMedicalPolicy(policyId, updatedMedicalPolicy);
    }

    @DeleteMapping("/{policyId}")
    public void deleteMedicalPolicy(@PathVariable long policyId) {
        medicalPolicyService.deleteMedicalPolicy(policyId);
    }
}

