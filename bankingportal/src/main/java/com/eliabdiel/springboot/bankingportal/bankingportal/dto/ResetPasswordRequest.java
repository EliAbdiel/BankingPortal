package com.eliabdiel.springboot.bankingportal.bankingportal.dto;

public record ResetPasswordRequest(String identifier, String resetToken, String newPassword) {

}
