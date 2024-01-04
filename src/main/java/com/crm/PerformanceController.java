package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping
    public List<Performance> getAllPerformances() {
        return performanceService.getAllPerformances();
    }

    @GetMapping("/{employeeId}")
    public Optional<Performance> getPerformanceByEmployeeId(@PathVariable long employeeId) {
        return performanceService.getPerformanceByEmployeeId(employeeId);
    }

    @PostMapping
    public Performance createPerformance(@RequestBody Performance performance) {
        return performanceService.createPerformance(performance);
    }

    @PutMapping("/{employeeId}")
    public Performance updatePerformance(@PathVariable long employeeId, @RequestBody Performance updatedPerformance) {
        return performanceService.updatePerformance(employeeId, updatedPerformance);
    }

    @DeleteMapping("/{employeeId}")
    public void deletePerformance(@PathVariable long employeeId) {
        performanceService.deletePerformance(employeeId);
    }
}

