package com.crm;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="invoicee")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceId;
    private LocalDate invoiceDate;
    private String customerId;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    
    private List<InvoiceItem> invoiceItems;

    private double totalAmount;
    private String status;
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(Long id, String invoiceId, LocalDate invoiceDate, String customerId, List<InvoiceItem> invoiceItems,
			double totalAmount, String status) {
		super();
		this.id = id;
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.customerId = customerId;
		this.invoiceItems = invoiceItems;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}
	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    
}

