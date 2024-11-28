package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }
}
