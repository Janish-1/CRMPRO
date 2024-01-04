package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{reportId}")
    public Optional<Report> getReportById(@PathVariable long reportId) {
        return reportService.getReportById(reportId);
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    @PutMapping("/{reportId}")
    public Report updateReport(@PathVariable long reportId, @RequestBody Report updatedReport) {
        return reportService.updateReport(reportId, updatedReport);
    }

    @DeleteMapping("/{reportId}")
    public void deleteReport(@PathVariable long reportId) {
        reportService.deleteReport(reportId);
    }
}
