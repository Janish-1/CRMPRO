package com.crm;

//LeadService.java
import java.util.List;

public interface LeadService {

 List<Lead> getAllLeads();

 Lead getLeadById(long leadId);

 Lead createLead(Lead lead);

 Lead updateLead(long leadId, Lead lead);

 void deleteLead(long leadId);
}

