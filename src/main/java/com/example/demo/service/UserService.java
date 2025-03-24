package com.example.demo.service;

import com.example.demo.model.UserAgency;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserAgency saveUser(UserAgency user){
        return userRepository.save(user);
    }

    public UserAgency findUserByPasswordAndNameUser(String password, String nameUser){
        return userRepository.findUserByPasswordAndNameUser(password, nameUser);
    }

    public List<UserAgency> findUserByCustomer(Boolean customer){
        return userRepository.findAllByCustomer(customer);
    }

    public UserAgency findUserAgenciesById(Long id){
        return userRepository.findUserAgenciesById(id);
    }

}
