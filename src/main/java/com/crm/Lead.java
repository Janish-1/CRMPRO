package com.crm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leads")
public class Lead {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long leadId;
 private String name;
 private String email;
 private String phone;
 private String requirement;
public long getLeadId() {
	return leadId;
}
public void setLeadId(long leadId) {
	this.leadId = leadId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getRequirement() {
	return requirement;
}
public void setRequirement(String requirement) {
	this.requirement = requirement;
}

 
}
