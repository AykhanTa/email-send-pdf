package com.example.email_send_pdf.service;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendPdfEmail(String toEmail, byte[] pdfBytes) throws MessagingException;
}
