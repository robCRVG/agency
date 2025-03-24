package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O número da conta deve ser informada")
    private Long accountNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAgency accountCustomer;

    private Double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UserAgency getAccountCustomer() {
        return accountCustomer;
    }

    public void setAccountCustomer(UserAgency accountCustomer) {
        this.accountCustomer = accountCustomer;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
