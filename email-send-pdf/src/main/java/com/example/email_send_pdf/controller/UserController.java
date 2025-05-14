package com.example.email_send_pdf.controller;

import com.example.email_send_pdf.service.EmailService;
import com.example.email_send_pdf.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final EmailService emailService;
    private final PdfService pdfService;

    @PostMapping("/send-pdf")
    public ResponseEntity<String> sendUserPdf(@RequestBody String finCode,@RequestBody String email) {
        try {
            byte[] pdf = pdfService.generateUserPdf(finCode);
            emailService.sendPdfEmail(email, pdf);
            return ResponseEntity.ok("PDF emailə göndərildi.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Xəta baş verdi: " + e.getMessage());
        }
    }

}
