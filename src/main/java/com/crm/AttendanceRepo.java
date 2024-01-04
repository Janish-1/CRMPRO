package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
    // Additional methods if needed
}

