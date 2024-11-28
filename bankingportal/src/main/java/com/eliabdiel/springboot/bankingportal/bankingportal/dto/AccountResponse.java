package com.eliabdiel.springboot.bankingportal.bankingportal.dto;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.Account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountResponse {

    private String accountNumber;

    private double balance;

    private String accountType;

    private String branch;

    private String ifscCode;

    public AccountResponse(Account account) {
        this.accountNumber = account.getAccountNumber();
        this.balance = account.getBalance();
        this.accountType = account.getAccountType();
        this.branch = account.getBranch();
        this.ifscCode = account.getIfscCode();
    }

}
