package com.crm;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentManager {
    private List<Appointment> appointments;

    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    public void scheduleAppointment(Long appointmentId, LocalDateTime dateTime, String customerName, String purpose) {
        Appointment appointment = new Appointment(appointmentId, dateTime, customerName, purpose);
        appointments.add(appointment);
    }

    @SuppressWarnings("unlikely-arg-type")
	public void cancelAppointment(String appointmentId) {
        appointments.removeIf(appointment -> appointment.getAppointmentId().equals(appointmentId));
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Appointment> getAppointmentsByCustomer(String customerName) {
        List<Appointment> customerAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getCustomerName().equalsIgnoreCase(customerName)) {
                customerAppointments.add(appointment);
            }
        }
        return customerAppointments;
    }
}
