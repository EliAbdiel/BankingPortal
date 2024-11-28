package com.eliabdiel.springboot.bankingportal.bankingportal.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.User;
import com.eliabdiel.springboot.bankingportal.bankingportal.exception.InvalidTokenException;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.LoginRequest;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.OtpRequest;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.OtpVerificationRequest;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    public ResponseEntity<String> registerUser(User user);

    public ResponseEntity<String> login(LoginRequest loginRequest, HttpServletRequest request) throws InvalidTokenException;

    public ResponseEntity<String> generateOtp(OtpRequest otpRequest);

    public ResponseEntity<String> verifyOtpAndLogin(OtpVerificationRequest otpVerificationRequest) throws InvalidTokenException;

    public ResponseEntity<String> updateUser(User updatedUser);

    public ModelAndView logout(String token) throws InvalidTokenException;

    public boolean resetPassword(User user, String newPassword);

    public User saveUser(User user);

    public User getUserByIdentifier(String identifier);

    public User getUserByAccountNumber(String accountNumber);

    public User getUserByEmail(String email);
}
