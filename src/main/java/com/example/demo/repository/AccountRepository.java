package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.UserAgency;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserAgency(UserAgency userAgency);
    Double findBalanceById(Long id);
    Account findAccountById(Long id);

    Account findAccountByAccountNumber(Long accountNumber);

    @Query("update Account a set a.balance = :balance where a.id = :id")
    @Modifying
    void updateBalanceById(Double balance, Long id);
}
