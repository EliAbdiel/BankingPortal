package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class AccountDoesNotExistException extends RuntimeException {

    public AccountDoesNotExistException(String message) {
        super(message);
    }
}
