package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    // Additional methods if needed
}


