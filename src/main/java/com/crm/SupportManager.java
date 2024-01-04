package com.crm;

import java.util.List;

public class SupportManager {
private List<SupportTicket> tickets;

public SupportManager() {
	super();
	// TODO Auto-generated constructor stub
}

public SupportManager(List<SupportTicket> tickets) {
	super();
	this.tickets = tickets;
}

public List<SupportTicket> getTickets() {
	return tickets;
}

public void setTickets(List<SupportTicket> tickets) {
	this.tickets = tickets;
}
    
    /* public SupportManager() {
        tickets = new ArrayList<>();
    }
    
    public void createTicket(Customer customer, String issueDescription) {
        SupportTicket ticket = new SupportTicket();
        tickets.add(ticket);
    }
    
    public void resolveTicket(SupportTicket ticket) {
        ticket.resolveTicket();
    }

	public SupportManager(List<SupportTicket> tickets) {
		super();
		this.tickets = tickets;
	}*/

    
}
