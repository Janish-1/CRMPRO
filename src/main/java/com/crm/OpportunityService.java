package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpportunityService {

    @Autowired
    private OpportunityRepo opportunityRepository;

    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    public Optional<Opportunity> getOpportunityById(long opportunityId) {
        return opportunityRepository.findById(opportunityId);
    }

    public Opportunity createOpportunity(Opportunity opportunity) {
        // In a real application, you might add validation or other business logic
        return opportunityRepository.save(opportunity);
    }

    public Opportunity updateOpportunity(long opportunityId, Opportunity updatedOpportunity) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunityId);
        if (optionalOpportunity.isPresent()) {
            Opportunity opportunity = optionalOpportunity.get();
            opportunity.setDescription(updatedOpportunity.getDescription());
            opportunity.setAmount(updatedOpportunity.getAmount());
            return opportunityRepository.save(opportunity);
        }
        return null; // Handle not found scenario
    }

    public void deleteOpportunity(long opportunityId) {
        opportunityRepository.deleteById(opportunityId);
    }
}

