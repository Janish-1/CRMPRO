package com.crm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="mp")
public class MedicalPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long policyId;

    private String policyName;
    private String coverageDetails;
    private String eligibilityCriteria;
	public MedicalPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicalPolicy(long policyId, String policyName, String coverageDetails, String eligibilityCriteria) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.coverageDetails = coverageDetails;
		this.eligibilityCriteria = eligibilityCriteria;
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
	public String getCoverageDetails() {
		return coverageDetails;
	}
	public void setCoverageDetails(String coverageDetails) {
		this.coverageDetails = coverageDetails;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

    
}

