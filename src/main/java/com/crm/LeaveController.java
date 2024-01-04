package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leave-requests")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public List<Leave> getAllLeaveRequests() {
        return leaveService.getAllLeaveRequests();
    }

    @GetMapping("/{employeeId}")
    public Optional<Leave> getLeaveRequestByEmployeeId(@PathVariable long employeeId) {
        return leaveService.getLeaveRequestByEmployeeId(employeeId);
    }

    @PostMapping
    public Leave createLeaveRequest(@RequestBody Leave leave) {
        return leaveService.createLeaveRequest(leave);
    }

    @PutMapping("/{employeeId}")
    public Leave updateLeaveRequest(@PathVariable long employeeId, @RequestBody Leave updatedLeave) {
        return leaveService.updateLeaveRequest(employeeId, updatedLeave);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteLeaveRequest(@PathVariable long employeeId) {
        leaveService.deleteLeaveRequest(employeeId);
    }
}

