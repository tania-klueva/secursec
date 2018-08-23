package com.example.secursec.utils;

import com.example.secursec.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;



@Component
public class UserEditor extends PropertyEditorSupport {
    @Autowired
    PasswordEncoder passwordEncoder;

//    public void coder(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//    }

    @Override
    public void setValue(Object o) {
        User user = (User) o;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
