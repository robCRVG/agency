package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.UserAgency;
import com.example.demo.service.AccountService;
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

    @PostMapping("registerAccount")
    public ModelAndView registerAccount(@ModelAttribute("account") @Valid Account account) {
        this.accountService.saveAccount(account);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("userAgency", new UserAgency());

        return mv;
    }

    @GetMapping("deposit")
    public ModelAndView depositAccount() {
        ModelAndView mv = new ModelAndView("deposit");
        mv.addObject("account", new Account());
        return mv;
    }

    @GetMapping("withdraw")
    public ModelAndView withdrawAccount() {
        ModelAndView mv = new ModelAndView("withdraw");
        mv.addObject("account", new Account());
        return mv;
    }

    @GetMapping("transfer")
    public ModelAndView transferAccount() {
        ModelAndView mv = new ModelAndView("transfer");
        mv.addObject("account", new Account());
        return mv;
    }
}
