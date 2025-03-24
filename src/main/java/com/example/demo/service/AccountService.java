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

    public Account finByUserAgency(UserAgency userAgency) {
        return this.accountRepository.findByUserAgency(userAgency);
    }
}
