package com.example.email_send_pdf.repository;

import com.example.email_send_pdf.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findByFinCode(String finCode);
}
