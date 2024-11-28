package com.eliabdiel.springboot.bankingportal.bankingportal.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApiMessages {

    ACCOUNT_NOT_FOUND("Account does not exist"),
    AMOUNT_EXCEED_100_000_ERROR("Amount cannot be greater than 100,000"),
    AMOUNT_NEGATIVE_ERROR("Amount must be greater than 0"),
    AMOUNT_NOT_MULTIPLE_OF_100_ERROR("Amount must be in multiples of 100"),
    BALANCE_INSUFFICIENT_ERROR("Insufficient balance"),
    CASH_TRANSFER_SAME_ACCOUNT_ERROR("Source and target account cannot be the same"),
    EMAIL_SUBJECT_LOGIN("New login to OneStopBank"),
    EMAIL_SUBJECT_OTP("OTP Verification"),
    IDENTIFIER_MISSING_ERROR("Missing identifier"),
    OTP_INVALID_ERROR("Invalid OTP"),
    OTP_GENERATION_LIMIT_EXCEEDED("OTP generation limit exceeded. Please try again after %d minutes"),
    OTP_MISSING_ERROR("Missing OTP"),
    OTP_SENT_FAILURE("{\"message\": \"Failed to send OTP to: %s\"}"),
    OTP_SENT_SUCCESS("{\"message\": \"OTP sent successfully to: %s\"}"),
    PASSWORD_CONTAINS_WHITESPACE_ERROR("Password cannot contain any whitespace characters"),
    PASSWORD_EMPTY_ERROR("Password cannot be empty"),
    PASSWORD_INVALID_ERROR("Invalid password"),
    PASSWORD_RESET_FAILURE("Failed to reset password"),
    PASSWORD_RESET_SUCCESS("{\"message\": \"Password reset successfully\"}"),
    PASSWORD_RESET_TOKEN_ISSUED("{\"passwordResetToken\": \"%s\"}"),
    PASSWORD_TOO_LONG_ERROR("Password must be less than 128 characters long"),
    PASSWORD_TOO_SHORT_ERROR("Password must be at least 8 characters long"),
    PIN_ALREADY_EXISTS("PIN already created"),
    PIN_EMPTY_ERROR("PIN cannot be empty"),
    PIN_FORMAT_INVALID_ERROR("PIN must be 4 digits"),
    PIN_INVALID_ERROR("Invalid PIN"),
    PIN_NOT_CREATED("PIN has not been created for this account"),
    TOKEN_INVALID_ERROR("Token is invalid"),
    TOKEN_ISSUED_SUCCESS("{ \"token\": \"%s\" }"),
    USER_ADDRESS_EMPTY_ERROR("Address cannot be empty"),
    USER_COUNTRY_CODE_EMPTY_ERROR("Country code cannot be empty"),
    USER_COUNTRY_CODE_INVALID_ERROR("Invalid country code: %s"),
    USER_DETAILS_EMPTY_ERROR("User details cannot be empty"),
    USER_EMAIL_ADDRESS_INVALID_ERROR("Invalid email: %s"),
    USER_EMAIL_ALREADY_EXISTS_ERROR("Email already exists"),
    USER_EMAIL_EMPTY_ERROR("Email cannot be empty"),
    USER_NAME_EMPTY_ERROR("Name cannot be empty"),
    USER_NOT_FOUND_BY_ACCOUNT("User not found for the given account number: %s"),
    USER_NOT_FOUND_BY_EMAIL("User not found for the given email: %s"),
    USER_NOT_FOUND_BY_IDENTIFIER("User not found for the given identifier: %s"),
    USER_PHONE_NUMBER_ALREADY_EXISTS_ERROR("Phone number already exists"),
    USER_PHONE_NUMBER_EMPTY_ERROR("Phone number cannot be empty"),
    USER_PHONE_NUMBER_INVALID_ERROR("Invalid phone number: %s for country code: %s");

    @Getter
    private final String message;
}
