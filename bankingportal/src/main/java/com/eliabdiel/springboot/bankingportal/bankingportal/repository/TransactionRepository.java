package com.eliabdiel.springboot.bankingportal.bankingportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.Transaction;

@Component
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    List<Transaction> findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber(String sourceAccountNumber, String targetAccountNumber);
}
