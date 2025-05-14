package com.example.email_send_pdf.dto;

import lombok.Data;

@Data
public class PdfRequest {
    private String finCode;
    private String email;
}
