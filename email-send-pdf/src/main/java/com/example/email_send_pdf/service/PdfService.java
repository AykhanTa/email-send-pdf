package com.example.email_send_pdf.service;

import com.itextpdf.text.DocumentException;

public interface PdfService {
    byte[] generateUserPdf(String finCode) throws DocumentException;
}
