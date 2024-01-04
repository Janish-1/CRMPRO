package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long attendanceId) {
        return attendanceRepository.findById(attendanceId);
    }

    public Attendance createAttendance(Attendance attendance) {
        // In a real application, you might add validation or other business logic
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long attendanceId, Attendance updatedAttendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendanceId);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            attendance.setEmployeeId(updatedAttendance.getEmployeeId());
            attendance.setCheckInTime(updatedAttendance.getCheckInTime());
            attendance.setCheckOutTime(updatedAttendance.getCheckOutTime());
            attendance.setStatus(updatedAttendance.getStatus());
            return attendanceRepository.save(attendance);
        }
        return null; // Handle not found scenario
    }

    public void deleteAttendance(Long attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }
}

