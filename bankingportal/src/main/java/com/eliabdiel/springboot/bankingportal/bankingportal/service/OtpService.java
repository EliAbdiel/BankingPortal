package com.eliabdiel.springboot.bankingportal.bankingportal.service;

import java.util.concurrent.CompletableFuture;

public interface OtpService {

    public String generateOTP(String accountNumber);

    public CompletableFuture<Void> sendOTPByEmail(String email, String name, String accountNumber, String otp);

    public boolean validateOTP(String accountNumber, String otp);
}
