package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.UserAgency;
import com.example.demo.repository.AccountRepository;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        try{
            return accountRepository.save(account);
        } catch (OptimisticLockException e){
            throw new OptimisticLockException();
        }
    }

    public Account updateAccount(Account account) {
        try{
            return this.accountRepository.save(account);
        } catch (OptimisticLockException e){
            throw new OptimisticLockException();
        }
    }

    public Account finByUserAgency(UserAgency userAgency) {
        try{
            return this.accountRepository.findByUserAgency(userAgency);
        } catch (OptimisticLockException e){
            throw new OptimisticLockException();
        }
    }

    public Account findAccountById(Long id) {
        try{
            return this.accountRepository.findAccountById(id);
        } catch (OptimisticLockException e){
            throw new OptimisticLockException();
        }

    }

    public Account findAccountByAccountNumber(Long accountNumber) {
        try{
            return this.accountRepository.findAccountByAccountNumber(accountNumber);
        } catch (OptimisticLockException e){
            throw new OptimisticLockException();
        }
    }
}
