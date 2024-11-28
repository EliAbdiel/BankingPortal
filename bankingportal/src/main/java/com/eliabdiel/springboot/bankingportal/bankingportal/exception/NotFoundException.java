package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
