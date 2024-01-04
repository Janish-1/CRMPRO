package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepo leaveRepository;

    public List<Leave> getAllLeaveRequests() {
        return leaveRepository.findAll();
    }

    public Optional<Leave> getLeaveRequestByEmployeeId(long employeeId) {
        return leaveRepository.findById(employeeId);
    }

    public Leave createLeaveRequest(Leave leave) {
        // In a real application, you might add validation or other business logic
        return leaveRepository.save(leave);
    }

    public Leave updateLeaveRequest(long employeeId, Leave updatedLeave) {
        Optional<Leave> optionalLeave = leaveRepository.findById(employeeId);
        if (optionalLeave.isPresent()) {
            Leave leave = optionalLeave.get();
            leave.setStartDate(updatedLeave.getStartDate());
            leave.setEndDate(updatedLeave.getEndDate());
            leave.setLeaveType(updatedLeave.getLeaveType());
            leave.setReason(updatedLeave.getReason());
            return leaveRepository.save(leave);
        }
        return null; // Handle not found scenario
    }

    public void deleteLeaveRequest(long employeeId) {
        leaveRepository.deleteById(employeeId);
    }
}

