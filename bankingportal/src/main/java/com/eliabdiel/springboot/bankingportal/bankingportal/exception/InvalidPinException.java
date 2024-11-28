package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class InvalidPinException extends RuntimeException{

    public InvalidPinException(String message) {
        super(message);
    }
}
