package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class OtpRetryLimitExceededException extends RuntimeException{

    public OtpRetryLimitExceededException(String message) {
        super(message);
    }
}
