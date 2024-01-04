package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepo reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<Report> getReportById(long reportId) {
        return reportRepository.findById(reportId);
    }

    public Report createReport(Report report) {
        // In a real application, you might add validation or other business logic
        return reportRepository.save(report);
    }

    public Report updateReport(long reportId, Report updatedReport) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);
        if (optionalReport.isPresent()) {
            Report report = optionalReport.get();
            report.setReportName(updatedReport.getReportName());
            report.setReportType(updatedReport.getReportType());
            report.setReportContent(updatedReport.getReportContent());
            return reportRepository.save(report);
        }
        return null; // Handle not found scenario
    }

    public void deleteReport(long reportId) {
        reportRepository.deleteById(reportId);
    }
}

