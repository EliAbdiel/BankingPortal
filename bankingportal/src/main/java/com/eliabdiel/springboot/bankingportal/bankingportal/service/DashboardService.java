package com.eliabdiel.springboot.bankingportal.bankingportal.service;

import com.eliabdiel.springboot.bankingportal.bankingportal.dto.AccountResponse;
import com.eliabdiel.springboot.bankingportal.bankingportal.dto.UserResponse;

public interface DashboardService {

    public UserResponse getUserDetails(String accountNumber);

    public AccountResponse getAccountDetails(String accountNumber);
}
