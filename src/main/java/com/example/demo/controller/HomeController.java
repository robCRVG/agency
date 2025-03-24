package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.UserAgency;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @GetMapping("home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("userAgency", new UserAgency());
        return mv;
    }

    @PostMapping("login")
    public ModelAndView login(@ModelAttribute("userAgency") UserAgency userAgency) {
        ModelAndView mv = new ModelAndView("home");
        UserAgency objUserAgency = this.userService.findUserByPasswordAndNameUser(userAgency.getPassword(), userAgency.getNameUser());
        if(objUserAgency.getAdmin()){
            List<UserAgency> userAgencyList = this.userService.findUserByCustomer(Boolean.TRUE);
            mv = new ModelAndView("admin-bank");
            mv.addObject("account", new Account());
            mv.addObject("userAgencyList", userAgencyList);
        } else if(objUserAgency.getCustomer()){
            Account objAccount = this.accountService.finByUserAgency(objUserAgency);
            mv = new ModelAndView("account-operation");
            mv.addObject("userAgency", objUserAgency);
            mv.addObject("account", objAccount);
        }
        return mv;
    }

}
