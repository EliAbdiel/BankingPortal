package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
