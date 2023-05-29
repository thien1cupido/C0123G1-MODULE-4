package com.example.validate_form_register.controller;

import com.example.validate_form_register.dto.UserDTO;
import com.example.validate_form_register.model.User;
import com.example.validate_form_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String createUser(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO",userDTO);
        return "index";
    }

    @PostMapping("/save")
    public String saveUser(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, Model model) {
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "index";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            Boolean check = iUserService.createUser(user);
            model.addAttribute("user", user);
            model.addAttribute("check", check);
            return "result";
        }
    }
}
