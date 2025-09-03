package com.example.controller;

import com.example.entity.ReportData;
import com.example.service.PDFService;
import com.example.service.ReportService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ReportController {

    private final PDFService pdfService;
    private final ReportService reportService;

    public ReportController(PDFService pdfService, ReportService reportService) {
        this.pdfService = pdfService;
        this.reportService = reportService;
    }

    @GetMapping("/")
    public String home(Model model) {
        ReportData reportData = reportService.generateEmployeeReport();
        model.addAttribute("reportData", reportData);
        return "report-preview";
    }

    @GetMapping("/download-pdf")
    public ResponseEntity<Resource> downloadPdf() throws IOException {
        ReportData reportData = reportService.generateEmployeeReport();

        // Generate HTML from Thymeleaf template
        String htmlContent = pdfService.parseThymeleafTemplate("pdf-template", reportData);

        // Convert HTML to PDF
        byte[] pdfBytes = pdfService.generatePdfFromHtml(htmlContent);

        ByteArrayResource resource = new ByteArrayResource(pdfBytes);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=employee-report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdfBytes.length)
                .body(resource);
    }

    @GetMapping("/view-pdf")
    public ResponseEntity<Resource> viewPdf() throws IOException {
        ReportData reportData = reportService.generateEmployeeReport();

        // Generate HTML from Thymeleaf template
        String htmlContent = pdfService.parseThymeleafTemplate("pdf-template", reportData);

        // Convert HTML to PDF
        byte[] pdfBytes = pdfService.generatePdfFromHtml(htmlContent);

        ByteArrayResource resource = new ByteArrayResource(pdfBytes);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=employee-report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdfBytes.length)
                .body(resource);
    }
}