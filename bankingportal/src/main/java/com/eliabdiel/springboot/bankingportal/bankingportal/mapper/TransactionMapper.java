package com.eliabdiel.springboot.bankingportal.bankingportal.mapper;

import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.dto.TransactionDTO;
import com.eliabdiel.springboot.bankingportal.bankingportal.entity.Transaction;

@Component
public class TransactionMapper {

    public TransactionDTO toDto(Transaction transaction) {
        return new TransactionDTO(transaction);
    }
}
