package com.eliabdiel.springboot.bankingportal.bankingportal.dto;

public record AmountRequest(String accountNumber,
                            String pin,
                            double amount) {
                                
}
