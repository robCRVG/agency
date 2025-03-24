package com.example.demo.repository;

import com.example.demo.model.UserAgency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserAgency, Long> {
    UserAgency findUserByPasswordAndNameUser(String password, String nameUser);
    List<UserAgency> findAllByCustomer(Boolean customer);
    UserAgency findUserAgenciesById(Long id);
}
