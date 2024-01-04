package com.crm;

//LeadServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService {

 @Autowired
 private LeadRepository leadRepository;

 @Override
 public List<Lead> getAllLeads() {
     return leadRepository.findAll();
 }

 @Override
 public Lead getLeadById(long leadId) {
     Optional<Lead> leadOptional = leadRepository.findById(leadId);
     return leadOptional.orElse(null);
 }

 @Override
 public Lead createLead(Lead lead) {
     return leadRepository.save(lead);
 }

 @Override
 public Lead updateLead(long leadId, Lead lead) {
     if (leadRepository.existsById(leadId)) {
         lead.setLeadId(leadId);
         return leadRepository.save(lead);
     }
     return null;
 }

 @Override
 public void deleteLead(long leadId) {
     leadRepository.deleteById(leadId);
 }
}
