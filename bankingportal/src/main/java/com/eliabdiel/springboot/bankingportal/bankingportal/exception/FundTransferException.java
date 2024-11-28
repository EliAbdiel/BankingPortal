package com.eliabdiel.springboot.bankingportal.bankingportal.exception;

public class FundTransferException extends RuntimeException {

    public FundTransferException(String message) {
        super(message);
    }
}
