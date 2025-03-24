package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.UserAgency;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @PostMapping("registerAccount")
    public ModelAndView registerAccount(@ModelAttribute("account") @Valid Account account) {
        this.accountService.saveAccount(account);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("userAgency", new UserAgency());

        return mv;
    }

    @PostMapping("deposit")
        public ModelAndView depositAccount(@ModelAttribute("account")  Account account) {
        ModelAndView mv = new ModelAndView("deposit");
        mv.addObject("account", account);
        return mv;
    }

    @PostMapping("depositBalance")
    public ModelAndView depositBalance(@ModelAttribute("account")  Account account) {
        Account currentBalance = accountService.findAccountById(account.getId());
        Double balanceUpdated = currentBalance.getBalance() + account.getBalance();
        account.setBalance(balanceUpdated);
        this.accountService.updateAccount(account);
        ModelAndView mv = new ModelAndView("account-operation");
        mv.addObject("account", account);
        mv.addObject("userAgency", account.getUserAgency());
        return mv;
    }

    @PostMapping("withdraw")
    public ModelAndView withdrawAccount(@ModelAttribute("account")  Account account) {
        ModelAndView mv = new ModelAndView("withdraw");
        mv.addObject("account", account);
        return mv;
    }

    @PostMapping("withdrawBalance")
    public ModelAndView withdrawBalance(@ModelAttribute("account")  Account account) {
        Account currentBalance = accountService.findAccountById(account.getId());
        Double balanceUpdated = currentBalance.getBalance() - account.getBalance();
        account.setBalance(balanceUpdated);
        this.accountService.updateAccount(account);
        ModelAndView mv = new ModelAndView("account-operation");
        mv.addObject("account", account);
        mv.addObject("userAgency", account.getUserAgency());
        return mv;
    }

    @PostMapping("transfer")
    public ModelAndView transferAccount(@ModelAttribute("account") Account account) {
        ModelAndView mv = new ModelAndView("transfer");
        mv.addObject("account", account);
        return mv;
    }

    @PostMapping("transferValue")
    public ModelAndView transferValue(@ModelAttribute("account") Account account) {
        Double balanceUpdated = account.getBalance() - account.getValueTransfer();
        account.setBalance(balanceUpdated);
        this.accountService.updateAccount(account);
        Account accountDestination = accountService.findAccountByAccountNumber(account.getAccountDestination());
        accountDestination.setBalance(accountDestination.getBalance() + account.getValueTransfer());
        this.accountService.updateAccount(accountDestination);
        ModelAndView mv = new ModelAndView("account-operation");
        mv.addObject("account", account);
        mv.addObject("userAgency", account.getUserAgency());
        return mv;
    }
}
