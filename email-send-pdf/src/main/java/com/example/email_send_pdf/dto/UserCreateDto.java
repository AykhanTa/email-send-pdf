package com.example.email_send_pdf.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String finCode;
    private String email;
}
