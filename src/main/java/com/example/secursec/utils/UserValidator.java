package com.example.secursec.utils;

import com.example.secursec.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "null");
        int usernameLength = user.getUsername().length();
        int passwordLength = user.getPassword().length();
        if (usernameLength <6 || usernameLength>15) {
            errors.rejectValue("username", "message.length.error");
        } else if(passwordLength<6 || passwordLength>15) {
            errors.rejectValue("password", "message.length.error");
        }
    }
}
