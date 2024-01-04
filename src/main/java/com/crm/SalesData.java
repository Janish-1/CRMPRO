package com.crm;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales")
public class SalesData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salesId;

    private LocalDate salesDate;

    private String customerId;

    private String serviceName;

    private double amount;

	public SalesData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesData(long salesId, LocalDate salesDate, String customerId, String serviceName, double amount) {
		super();
		this.salesId = salesId;
		this.salesDate = salesDate;
		this.customerId = customerId;
		this.serviceName = serviceName;
		this.amount = amount;
	}

	public long getSalesId() {
		return salesId;
	}

	public void setSalesId(long salesId) {
		this.salesId = salesId;
	}

	public LocalDate getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(LocalDate salesDate) {
		this.salesDate = salesDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

    
}

