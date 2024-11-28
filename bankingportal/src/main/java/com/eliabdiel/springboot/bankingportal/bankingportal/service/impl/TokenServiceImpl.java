package com.eliabdiel.springboot.bankingportal.bankingportal.service.impl;

import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.exception.InvalidTokenException;
import com.eliabdiel.springboot.bankingportal.bankingportal.repository.AccountRepository;
import com.eliabdiel.springboot.bankingportal.bankingportal.repository.TokenRepository;
import com.eliabdiel.springboot.bankingportal.bankingportal.repository.UserRepository;
import com.eliabdiel.springboot.bankingportal.bankingportal.service.TokenService;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService{

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private final UserRepository userRepository;

    private final TokenRepository tokenRepository;

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateToken'");
    }

    @Override
    public String generateToken(UserDetails userDetails, Date expiry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateToken'");
    }

    @Override
    public String getUsernameFromToken(String token) throws InvalidTokenException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsernameFromToken'");
    }

    @Override
    public Date getExpirationDateFromToken(String token) throws InvalidTokenException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExpirationDateFromToken'");
    }

    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) throws InvalidTokenException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClaimFromToken'");
    }

    @Override
    public void saveToken(String token) throws InvalidTokenException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveToken'");
    }

    @Override
    public void validateToken(String token) throws InvalidTokenException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateToken'");
    }

    @Override
    public void invalidateToken(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invalidateToken'");
    }

}
