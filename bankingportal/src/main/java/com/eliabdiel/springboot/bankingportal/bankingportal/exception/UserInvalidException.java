package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class UserInvalidException extends RuntimeException {

    public UserInvalidException(String message) {
        super(message);
    }
}