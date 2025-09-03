package com.example.entity;

public class ReportSummary {
    private int totalEmployees;
    private Double totalSalary;
    private Double averageSalary;

    // Constructors, Getters and Setters
    public ReportSummary() {}

    public ReportSummary(int totalEmployees, Double totalSalary, Double averageSalary) {
        this.totalEmployees = totalEmployees;
        this.totalSalary = totalSalary;
        this.averageSalary = averageSalary;
    }

    // Getters and Setters
    public int getTotalEmployees() { return totalEmployees; }
    public void setTotalEmployees(int totalEmployees) { this.totalEmployees = totalEmployees; }

    public Double getTotalSalary() { return totalSalary; }
    public void setTotalSalary(Double totalSalary) { this.totalSalary = totalSalary; }

    public Double getAverageSalary() { return averageSalary; }
    public void setAverageSalary(Double averageSalary) { this.averageSalary = averageSalary; }
}