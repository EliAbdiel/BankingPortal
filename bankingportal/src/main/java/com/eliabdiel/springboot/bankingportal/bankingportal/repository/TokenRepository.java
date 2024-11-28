package com.eliabdiel.springboot.bankingportal.bankingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.Account;
import com.eliabdiel.springboot.bankingportal.bankingportal.entity.Token;

@Component
public interface TokenRepository extends JpaRepository<Token, Long>{

    Token findByToken(String token);

    Token[] findAllByAccount(Account account);

    void deleteByToken(String token);
}
