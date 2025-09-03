package com.example.service;

import com.example.entity.Employee;
import com.example.entity.ReportData;
import com.example.entity.ReportSummary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class ReportService {

    public ReportData generateEmployeeReport() {
        // Sample data - replace with your actual data source
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "John Doe", "IT", "john@example.com", 75000.0),
                new Employee(2L, "Jane Smith", "HR", "jane@example.com", 65000.0),
                new Employee(3L, "Bob Johnson", "Finance", "bob@example.com", 85000.0),
                new Employee(4L, "Alice Brown", "Marketing", "alice@example.com", 70000.0),
                new Employee(5L, "Charlie Wilson", "IT", "charlie@example.com", 80000.0)
        );

        // Calculate summary
        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        double averageSalary = totalSalary / employees.size();

        ReportSummary summary = new ReportSummary(
                employees.size(),
                totalSalary,
                averageSalary
        );

        // Format current date
        String generatedDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return new ReportData(
                "Employee Salary Report",
                generatedDate,
                employees,
                summary
        );
    }
}