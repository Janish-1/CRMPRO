package com.crm;


import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hrp")
public class HRPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long policyId;

    private String policyName;

    @ElementCollection
    private Map<String, String> policyDetails;

	public HRPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HRPolicy(long policyId, String policyName, Map<String, String> policyDetails) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyDetails = policyDetails;
	}

	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Map<String, String> getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(Map<String, String> policyDetails) {
		this.policyDetails = policyDetails;
	}

    
}

