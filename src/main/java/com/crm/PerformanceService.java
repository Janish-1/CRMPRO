package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepo performanceRepository;

    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }

    public Optional<Performance> getPerformanceByEmployeeId(long employeeId) {
        return performanceRepository.findById(employeeId);
    }

    public Performance createPerformance(Performance performance) {
        // In a real application, you might add validation or other business logic
        return performanceRepository.save(performance);
    }

    public Performance updatePerformance(long employeeId, Performance updatedPerformance) {
        Optional<Performance> optionalPerformance = performanceRepository.findById(employeeId);
        if (optionalPerformance.isPresent()) {
            Performance performance = optionalPerformance.get();
            performance.setProductivityScore(updatedPerformance.getProductivityScore());
            performance.setAttendanceScore(updatedPerformance.getAttendanceScore());
            performance.setTeamworkScore(updatedPerformance.getTeamworkScore());
            return performanceRepository.save(performance);
        }
        return null; // Handle not found scenario
    }

    public void deletePerformance(long employeeId) {
        performanceRepository.deleteById(employeeId);
    }
}

