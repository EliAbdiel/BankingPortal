package com.eliabdiel.springboot.bankingportal.bankingportal.dto;

public record FundTransferRequest(String sourceAccountNumber, String targetAccountNumber, double amount, String pin) {

}
