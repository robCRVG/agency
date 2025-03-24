package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.UserAgency;
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

    @GetMapping("home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("userAgency", new UserAgency());
        return mv;
    }

    @PostMapping("login")
    public ModelAndView login(@ModelAttribute("userAgency") UserAgency userAgency) {
        ModelAndView mv = new ModelAndView("home");
        UserAgency objUseragency = this.userService.findUserByPasswordAndNameUser(userAgency.getPassword(), userAgency.getNameUser());
        if(objUseragency.getAdmin()){
            mv = new ModelAndView("admin-bank");
            List<UserAgency> userAgencyList = this.userService.findUserByCustomer(Boolean.TRUE);
            mv.addObject("account", new Account());
            mv.addObject("userAgencyList", userAgencyList);
        } else if(objUseragency.getCustomer()){
            mv = new ModelAndView("account-operation");
        }

        return mv;

    }
}
