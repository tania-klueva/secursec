package com.example.secursec.controllers;

import com.example.secursec.models.User;
import com.example.secursec.service.UserService;
import com.example.secursec.utils.UserEditor;
import com.example.secursec.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@PropertySource("classpath:validation.properties")
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    UserEditor userEditor;
    @Autowired
    UserValidator userValidator;
    @Autowired
    Environment environment;

    @GetMapping("/login")
    public String login(){
    return "login";
    }

    @PostMapping("/success")
    public String success(){
    return "success";
    }

    @PostMapping("/fail")
    public String fail(){
    return "fail";
    }

    @GetMapping("/")
    public String main(){
    return "index";
    }

    @PostMapping("/save")
    public String signIn(User user, BindingResult result, Model model){
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            String errors = "";
            for (ObjectError error : allErrors) {
                errors += environment.getProperty(error.getCode());
            }
            model.addAttribute("error", errors);
            return "index";
        }
        userEditor.setValue(user);
        userService.save(user);
        return "redirect:/login";
    }

}
