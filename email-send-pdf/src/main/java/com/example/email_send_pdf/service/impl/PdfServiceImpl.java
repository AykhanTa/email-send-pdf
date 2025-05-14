package com.example.email_send_pdf.service.impl;

import com.example.email_send_pdf.exception.UserNotFoundException;
import com.example.email_send_pdf.models.UserDetails;
import com.example.email_send_pdf.repository.UserDetailsRepository;
import com.example.email_send_pdf.service.PdfService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
public class PdfServiceImpl implements PdfService {
    private final UserDetailsRepository userRepository;
    @Override
    public byte[] generateUserPdf(String fincode) throws DocumentException {
        UserDetails existUser=userRepository.findByFinCode(fincode);
        if(existUser==null){
            throw new UserNotFoundException("User can't be found!");
        }
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, baos);
        document.open();

        document.add(new Paragraph("Istifadeci Melumatlari"));
        document.add(new Paragraph("ID:"+existUser.getId()));
        document.add(new Paragraph("Ad: " + existUser.getFirstName()));
        document.add(new Paragraph("Soyad: " + existUser.getLastName()));
        document.add(new Paragraph("FIN: " + existUser.getFinCode()));
        document.add(new Paragraph("Email: " + existUser.getEmail()));
        document.add(new Paragraph("Dogum tarixi: " + existUser.getBirthDate()));

        document.close();

        return baos.toByteArray();
    }
}
