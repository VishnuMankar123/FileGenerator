package com.example.service;

import com.example.entity.ReportData;
import org.thymeleaf.TemplateEngine;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class PDFService {

    private final TemplateEngine templateEngine;

    public PDFService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdfFromHtml(String htmlContent) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            HtmlConverter.convertToPdf(htmlContent, outputStream);
            return outputStream.toByteArray();
        }
    }

    public String parseThymeleafTemplate(String templateName, ReportData reportData) {
        Context context = new Context();
        context.setVariable("reportData", reportData);
        return templateEngine.process(templateName, context);
    }
}