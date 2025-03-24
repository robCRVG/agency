package com.example.demo.controller;

import com.example.demo.model.UserAgency;
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

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("registerUser")
    public ModelAndView registerUser() {
        ModelAndView mv = new ModelAndView("register-user");
//        List<UserAgency> users = userService.findUserByCustomer(Boolean.TRUE);
        mv.addObject("userAgency", new UserAgency());
        return mv;
    }

    @PostMapping("register")
    public ModelAndView register(@ModelAttribute("userAgency") @Valid UserAgency userAgency,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("home");
        if(bindingResult.hasErrors()){
            return mv;
        }else{
            UserAgency objUserAgency = this.userService.saveUser(userAgency);
            redirectAttributes.addFlashAttribute("mensagem", "Usuário registrado com sucesso!");
            mv.addObject("userAgency", objUserAgency);
        }
        return mv;
    }
}
