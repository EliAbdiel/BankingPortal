package com.eliabdiel.springboot.bankingportal.bankingportal.service;

import org.springframework.http.ResponseEntity;

import com.eliabdiel.springboot.bankingportal.bankingportal.dto.OtpRequest;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.OtpVerificationRequest;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.ResetPasswordRequest;
import com.eliabdiel.springboot.bankingportal.bankingportal.entity.User;

public interface AuthService {

    public String generatePasswordResetToken(User user);

    public boolean verifyPasswordResetToken(String token, User user);

    public void deletePasswordResetToken(String token);

    public ResponseEntity<String> sendOtpForPasswordReset(OtpRequest otpRequest);

    public ResponseEntity<String> verifyOtpAndIssueResetToken(OtpVerificationRequest otpVerificationRequest);

    public ResponseEntity<String> resetPassword(ResetPasswordRequest resetPasswordRequest);
}
