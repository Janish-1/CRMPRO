package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunityController {

    @Autowired
    private OpportunityService opportunityService;

    @GetMapping
    public List<Opportunity> getAllOpportunities() {
        return opportunityService.getAllOpportunities();
    }

    @GetMapping("/{opportunityId}")
    public Optional<Opportunity> getOpportunityById(@PathVariable long opportunityId) {
        return opportunityService.getOpportunityById(opportunityId);
    }

    @PostMapping
    public Opportunity createOpportunity(@RequestBody Opportunity opportunity) {
        return opportunityService.createOpportunity(opportunity);
    }

    @PutMapping("/{opportunityId}")
    public Opportunity updateOpportunity(@PathVariable long opportunityId, @RequestBody Opportunity updatedOpportunity) {
        return opportunityService.updateOpportunity(opportunityId, updatedOpportunity);
    }

    @DeleteMapping("/{opportunityId}")
    public void deleteOpportunity(@PathVariable long opportunityId) {
        opportunityService.deleteOpportunity(opportunityId);
    }
}

