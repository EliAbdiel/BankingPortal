package com.eliabdiel.springboot.bankingportal.bankingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.OtpInfo;

@Component
public interface OtpInfoRepository extends JpaRepository<OtpInfo, Long>{

    OtpInfo findByAccountNumberAndOtp(String accountNumber, String otp);

    OtpInfo findByAccountNumber(String accountNumber);
}
