package com.example.email_send_pdf.service.impl;

import com.example.email_send_pdf.dto.UserCreateDto;
import com.example.email_send_pdf.models.UserDetails;
import com.example.email_send_pdf.repository.UserDetailsRepository;
import com.example.email_send_pdf.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    @Override
    public void addUser(UserCreateDto userDto) {
        UserDetails existUser=userDetailsRepository.findByFinCode(userDto.getFinCode());
        if(existUser!=null){
            throw new IllegalArgumentException("User already exists");
        }
        UserDetails newUser=new UserDetails();
        newUser.setFinCode(userDto.getFinCode());
        newUser.setEmail(userDto.getEmail());
        newUser.setBirthDate(userDto.getBirthDate());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        userDetailsRepository.save(newUser);
    }


}
