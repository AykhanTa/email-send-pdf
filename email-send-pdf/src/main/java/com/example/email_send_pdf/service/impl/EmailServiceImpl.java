package com.example.email_send_pdf.service.impl;

import com.example.email_send_pdf.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    @Override
    public void sendPdfEmail(String toEmail, byte[] pdfBytes) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject("İstifadəçi PDF Məlumatları");
        helper.setText("Əlavədə istifadəçi məlumatları olan PDF sənədi var.");
        helper.addAttachment("user-info.pdf", new ByteArrayResource(pdfBytes));

        mailSender.send(message);
    }
}
