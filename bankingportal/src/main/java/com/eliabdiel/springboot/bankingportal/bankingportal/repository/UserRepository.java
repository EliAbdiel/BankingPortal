package com.eliabdiel.springboot.bankingportal.bankingportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByAccountAccountNumber(String accountNumber);
}
