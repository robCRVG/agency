package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.UserAgency;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        return this.accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        return this.accountRepository.save(account);
    }

    public Account finByUserAgency(UserAgency userAgency) {
        return this.accountRepository.findByUserAgency(userAgency);
    }

    public void updateBalanceById(Double balance, Long id) {
         this.accountRepository.updateBalanceById(balance, id);
    }

    public Double findBalanceById(Long id) {
        return this.accountRepository.findBalanceById(id);
    }

    public Account findAccountById(Long id) {
        return this.accountRepository.findAccountById(id);
    }

    public Account findAccountByAccountNumber(Long accountNumber) {
        return this.accountRepository.findAccountByAccountNumber(accountNumber);
    }
}
