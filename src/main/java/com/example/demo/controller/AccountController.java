package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.UserAgency;
import com.example.demo.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("registerAccountCustomer")
    public ModelAndView register(@ModelAttribute("account") @Valid Account account) {
        ModelAndView mv = new ModelAndView("home");
            Account accountCustomer = this.accountService.saveAccount(account);
            mv.addObject("userAgency", new UserAgency());

        return mv;
    }
}
