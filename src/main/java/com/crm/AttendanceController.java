package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{attendanceId}")
    public Optional<Attendance> getAttendanceById(@PathVariable Long attendanceId) {
        return attendanceService.getAttendanceById(attendanceId);
    }

    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.createAttendance(attendance);
    }

    @PutMapping("/{attendanceId}")
    public Attendance updateAttendance(@PathVariable Long attendanceId, @RequestBody Attendance updatedAttendance) {
        return attendanceService.updateAttendance(attendanceId, updatedAttendance);
    }

    @DeleteMapping("/{attendanceId}")
    public void deleteAttendance(@PathVariable Long attendanceId) {
        attendanceService.deleteAttendance(attendanceId);
    }
}

