package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class InvalidOtpException extends RuntimeException {

    public InvalidOtpException(String message) {
        super(message);
    }
}
