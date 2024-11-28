package com.eliabdiel.springboot.bankingportal.bankingportal.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eliabdiel.springboot.bankingportal.bankingportal.dto.OtpRequest;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.OtpVerificationRequest;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.ResetPasswordRequest;
import com.eliabdiel.springboot.bankingportal.bankingportal.entity.PasswordResetToken;
import com.eliabdiel.springboot.bankingportal.bankingportal.entity.User;
import com.eliabdiel.springboot.bankingportal.bankingportal.repository.PasswordResetTokenRepository;
import com.eliabdiel.springboot.bankingportal.bankingportal.service.AuthService;
import com.eliabdiel.springboot.bankingportal.bankingportal.service.OtpService;
import com.eliabdiel.springboot.bankingportal.bankingportal.service.UserService;
import com.eliabdiel.springboot.bankingportal.bankingportal.util.ApiMessages;

import lombok.val;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private static final int EXPIRATION_HOURS = 24;

    private final OtpService otpService;

    private final UserService userService;

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    @Transactional
    public String generatePasswordResetToken(User user) {
        
        val existingToken = passwordResetTokenRepository.findByUser(user);

        if (isExistingTokenValid(existingToken)) {
            return existingToken.getToken();
        }

        val token = UUID.randomUUID().toString();
        val expiryDateTime = LocalDateTime.now().plusHours(EXPIRATION_HOURS);
        val resetToken = new PasswordResetToken(token, user, expiryDateTime);

        passwordResetTokenRepository.save(resetToken);

        return token;
    }

    @Override
    public boolean verifyPasswordResetToken(String token, User user) {
        
        return passwordResetTokenRepository.findByToken(token)
            .map(resetToken -> {
                deletePasswordResetToken(token);
                return user.equals(resetToken.getUser()) && resetToken.isTokenValid();
            })
            .orElse(false);
    }

    @Override
    public void deletePasswordResetToken(String token) {
        
        passwordResetTokenRepository.deleteByToken(token);
    }

    @Override
    public ResponseEntity<String> sendOtpForPasswordReset(OtpRequest otpRequest) {
        
        log.info("Received OTP request for identifier: {}", otpRequest.identifier());

        val user = userService.getUserByIdentifier(otpRequest.identifier());
        val accountNumber = user.getAccount().getAccountNumber();
        val generatedOtp = otpService.generateOTP(accountNumber);

        return sendOtpEmail(user, accountNumber, generatedOtp);
    }

    @Override
    public ResponseEntity<String> verifyOtpAndIssueResetToken(OtpVerificationRequest otpVerificationRequest) {
        
        validateOtpRequest(otpVerificationRequest);

        val user = userService.getUserByIdentifier(otpVerificationRequest.identifier());
        val accountNumber = user.getAccount().getAccountNumber();

        if (!otpService.validateOTP(accountNumber, otpVerificationRequest.otp())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiMessages.OTP_INVALID_ERROR.getMessage());
        }

        String resetToken = generatePasswordResetToken(user);

        return ResponseEntity.ok(String.format(ApiMessages.PASSWORD_RESET_TOKEN_ISSUED.getMessage(), resetToken));
    }

    @Override
    @Transactional
    public ResponseEntity<String> resetPassword(ResetPasswordRequest resetPasswordRequest) {
        
        val user = userService.getUserByIdentifier(resetPasswordRequest.identifier());

        if (!verifyPasswordResetToken(resetPasswordRequest.resetToken(), user)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiMessages.TOKEN_INVALID_ERROR.getMessage());
        }

        try {
            boolean passwordResetSuccessful = userService.resetPassword(user, resetPasswordRequest.newPassword());
            if (passwordResetSuccessful) {
                return ResponseEntity.ok(ApiMessages.PASSWORD_RESET_SUCCESS.getMessage());
            } else {
                return ResponseEntity.internalServerError().body(ApiMessages.PASSWORD_RESET_FAILURE.getMessage());
            }
        } catch (Exception e) {
            log.error("Error resetting password for user: {}", user.getId(), e);
            return ResponseEntity.internalServerError().body(ApiMessages.PASSWORD_RESET_FAILURE.getMessage());
        }
    }

    private boolean isExistingTokenValid(PasswordResetToken existingToken) {
        return existingToken != null && existingToken.getExpiryDateTime().isAfter(LocalDateTime.now().plusMinutes(5));
    }

    @SuppressWarnings("unused")
    private ResponseEntity<String> sendOtpEmail(User user, String accountNumber, String generateOtp) {
        val emailSendingFuture = otpService.sendOTPByEmail(user.getEmail(), user.getName(), accountNumber, generateOtp);
        val successResponse = ResponseEntity.ok(String.format(ApiMessages.OTP_SENT_SUCCESS.getMessage(), user.getEmail()));
        val failureResponse = ResponseEntity.internalServerError().body(String.format(ApiMessages.OTP_SENT_FAILURE.getMessage(), user.getEmail()));
        return emailSendingFuture.thenApply(result -> successResponse).exceptionally(e -> failureResponse).join();
    }

    private void validateOtpRequest(OtpVerificationRequest otpVerificationRequest) {
        if (otpVerificationRequest.identifier() == null || otpVerificationRequest.identifier().isBlank()) {
            throw new IllegalArgumentException(ApiMessages.IDENTIFIER_MISSING_ERROR.getMessage());
        }
        if (otpVerificationRequest.otp() == null || otpVerificationRequest.otp().isBlank()) {
            throw new IllegalArgumentException(ApiMessages.OTP_MISSING_ERROR.getMessage());
        }
    }

}
