package com.example.secursec.service;

import com.example.secursec.dao.UserDAO;
import com.example.secursec.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.findUserByUsername(s).get();
    }
}
