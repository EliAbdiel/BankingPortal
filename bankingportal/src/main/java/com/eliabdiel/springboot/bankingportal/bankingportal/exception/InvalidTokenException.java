package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class InvalidTokenException extends Exception {

    public InvalidTokenException(String message) {
        super(message);
    }
}
