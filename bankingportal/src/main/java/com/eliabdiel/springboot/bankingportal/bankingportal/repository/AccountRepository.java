package com.eliabdiel.springboot.bankingportal.bankingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.Account;

@Component
public interface AccountRepository extends JpaRepository<Account, Long>{

    Account findByAccountNumber(String accountNumber);
}
