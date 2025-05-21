package com.example.email_send_pdf.controller;

import com.example.email_send_pdf.dto.PdfRequest;
import com.example.email_send_pdf.dto.UserCreateDto;
import com.example.email_send_pdf.service.EmailService;
import com.example.email_send_pdf.service.PdfService;
import com.example.email_send_pdf.service.UserDetailsService;
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
    private final UserDetailsService userDetailsService;

    @PostMapping("/send-pdf")
    public ResponseEntity<String> sendUserPdf(@RequestBody PdfRequest pdfRequest) {
        try {
            byte[] pdf = pdfService.generateUserPdf(pdfRequest.getFinCode());
            emailService.sendPdfEmail(pdfRequest.getEmail(), pdf);
            return ResponseEntity.ok("PDF emailə göndərildi.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Xəta baş verdi: " + e.getMessage());
        }
    }

    @PostMapping( "/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserCreateDto userDto) {
        try {
            userDetailsService.addUser(userDto);
            return ResponseEntity.ok("User added.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Xəta baş verdi: " + e.getMessage());
        }
    }


}
