package com.example.email_send_pdf.service;

import com.example.email_send_pdf.dto.UserCreateDto;

public interface UserDetailsService {
    void addUser(UserCreateDto userDto);
}
