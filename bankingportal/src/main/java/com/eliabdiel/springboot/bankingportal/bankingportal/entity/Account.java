package com.eliabdiel.springboot.bankingportal.bankingportal.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String accountNumber;

    @NotBlank
    private String accountType = "Savings";

    private String accountStatus;

    private double balance;

    private String branch = "NIT";

    private String ifscCode = "NIT001";

    private String pin;

    // Establishing a one-to-one relationship with the user
    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Establishing a one-to-many relationship with the token
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Token> tokens = new ArrayList<>();
}
