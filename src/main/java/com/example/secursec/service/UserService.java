package com.example.secursec.service;

import com.example.secursec.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    void save(User user);
    List<User> findAll();
    Optional<User> findById(int id);
}
