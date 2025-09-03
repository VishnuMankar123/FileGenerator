package com.example.entity;

import java.util.List;

public class ReportData {
    private String reportTitle;
    private String generatedDate;
    private List<Employee> employees;
    private ReportSummary summary;

    // Constructors, Getters and Setters
    public ReportData() {}

    public ReportData(String reportTitle, String generatedDate,
                      List<Employee> employees, ReportSummary summary) {
        this.reportTitle = reportTitle;
        this.generatedDate = generatedDate;
        this.employees = employees;
        this.summary = summary;
    }

    // Getters and Setters
    public String getReportTitle() { return reportTitle; }
    public void setReportTitle(String reportTitle) { this.reportTitle = reportTitle; }

    public String getGeneratedDate() { return generatedDate; }
    public void setGeneratedDate(String generatedDate) { this.generatedDate = generatedDate; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    public ReportSummary getSummary() { return summary; }
    public void setSummary(ReportSummary summary) { this.summary = summary; }
}