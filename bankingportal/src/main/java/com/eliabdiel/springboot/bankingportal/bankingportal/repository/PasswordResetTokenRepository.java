package com.eliabdiel.springboot.bankingportal.bankingportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.entity.PasswordResetToken;
import com.eliabdiel.springboot.bankingportal.bankingportal.entity.User;

@Component
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long>{

    Optional<PasswordResetToken> findByToken(String token);

    PasswordResetToken findByUser(User user);

    void deleteByToken(String token);
}
