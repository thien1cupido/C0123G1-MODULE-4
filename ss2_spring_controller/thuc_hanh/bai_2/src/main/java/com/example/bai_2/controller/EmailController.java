package com.example.bai_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping("/")
    String getEmailRegex() {
        return "regex_email";
    }

    @PostMapping("/validate")
    String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isValid = this.validate(email);
        String result;
        if (!isValid) {
            result=" is invalid";
        }else {
            result="is valid";
        }
        model.addAttribute("result",result);
        model.addAttribute("email", email);
        return "regex_email";
    }

    private boolean validate(String regex) {
        return regex.matches(EMAIL_REGEX);
    }

}
