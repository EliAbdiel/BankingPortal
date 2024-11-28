package com.eliabdiel.springboot.bankingportal.bankingportal.service;

import java.util.List;

import com.eliabdiel.springboot.bankingportal.bankingportal.dto.TransactionDTO;

public interface TransactionService {

    public List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber);
}
