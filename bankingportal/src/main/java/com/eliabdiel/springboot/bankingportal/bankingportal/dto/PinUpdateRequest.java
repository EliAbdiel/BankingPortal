package com.eliabdiel.springboot.bankingportal.bankingportal.dto;

public record PinUpdateRequest(String accountNumber, String oldPin, String newPin, String password) {

}
