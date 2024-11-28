package com.eliabdiel.springboot.bankingportal.bankingportal.service.impl;

import org.springframework.stereotype.Component;

import com.eliabdiel.springboot.bankingportal.bankingportal.dto.AccountResponse;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.UserResponse;
import com.eliabdiel.springboot.bankingportal.bankingportal.exception.NotFoundException;
import com.eliabdiel.springboot.bankingportal.bankingportal.repository.AccountRepository;
import com.eliabdiel.springboot.bankingportal.bankingportal.repository.UserRepository;
import com.eliabdiel.springboot.bankingportal.bankingportal.service.DashboardService;
import com.eliabdiel.springboot.bankingportal.bankingportal.util.ApiMessages;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Component
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;

    private final AccountRepository accountRepository;

    @Override
    public UserResponse getUserDetails(String accountNumber) {
        
        val user = userRepository.findByAccountAccountNumber(accountNumber)
            .orElseThrow(() -> new NotFoundException(
                String.format(ApiMessages.USER_NOT_FOUND_BY_ACCOUNT.getMessage(), accountNumber)
            ));

        return new UserResponse(user);
    }

    @Override
    public AccountResponse getAccountDetails(String accountNumber) {
        
        val account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            throw new NotFoundException(String.format(ApiMessages.USER_NOT_FOUND_BY_ACCOUNT.getMessage(), accountNumber));
        }

        return new AccountResponse(account);
    }

}
