package com.crm;

//LeadController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

 @Autowired
 private LeadService leadService;

 @GetMapping
 public List<Lead> getAllLeads() {
     return leadService.getAllLeads();
 }

 @GetMapping("/{leadId}")
 public ResponseEntity<Lead> getLeadById(@PathVariable long leadId) {
     Lead lead = leadService.getLeadById(leadId);
     if (lead != null) {
         return new ResponseEntity<>(lead, HttpStatus.OK);
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

 @PostMapping
 public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
     Lead createdLead = leadService.createLead(lead);
     return new ResponseEntity<>(createdLead, HttpStatus.CREATED);
 }

 @PutMapping("/{leadId}")
 public ResponseEntity<Lead> updateLead(@PathVariable long leadId, @RequestBody Lead lead) {
     Lead updatedLead = leadService.updateLead(leadId, lead);
     if (updatedLead != null) {
         return new ResponseEntity<>(updatedLead, HttpStatus.OK);
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

 @DeleteMapping("/{leadId}")
 public ResponseEntity<Void> deleteLead(@PathVariable long leadId) {
     leadService.deleteLead(leadId);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
}
