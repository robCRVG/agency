package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O número da conta deve ser informada!")
    private Long accountNumber;

    @NotNull(message = "O saldo deve ser informado!")
    private Double balance;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAgency userAgency;

    @Transient
    private Long accountDestination;

    @Transient
    private Double valueTransfer;

    public Account() {}

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

    public UserAgency getUserAgency() {
        return userAgency;
    }

    public void setUserAgency(UserAgency userAgency) {
        this.userAgency = userAgency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(Long accountDestination) {
        this.accountDestination = accountDestination;
    }

    public Double getValueTransfer() {
        return valueTransfer;
    }

    public void setValueTransfer(Double valueTransfer) {
        this.valueTransfer = valueTransfer;
    }
}
