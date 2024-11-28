package com.eliabdiel.springboot.bankingportal.bankingportal.dto;

import java.util.Date;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.Transaction;
import com.eliabdiel.springboot.bankingportal.bankingportal.entity.TransactionType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

@Data
@NoArgsConstructor
public class TransactionDTO {

    private Long id;

    private double amount;

    private TransactionType transactionType;

    private Date transactionDate;

    private String sourceAccountNumber;

    private String targetAccountNumber;

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.amount = transaction.getAmount();
        this.transactionType = transaction.getTransactionType();
        this.transactionDate = transaction.getTransactionDate();
        this.sourceAccountNumber = transaction.getSourceAccount().getAccountNumber();

        val targetAccount = transaction.getTargetAccount();

        var targetAccountNumber = "N/A";

        if (targetAccount != null) {
            targetAccountNumber = targetAccount.getAccountNumber();
        }

        this.targetAccountNumber = targetAccountNumber;
    }
}
