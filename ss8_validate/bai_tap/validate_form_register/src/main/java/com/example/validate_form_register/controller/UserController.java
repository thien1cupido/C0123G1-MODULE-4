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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public ModelAndView showList(){
        return new ModelAndView("list","userList",iUserService.findAllUser());
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "index";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute @Validated User user, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "index";
        } else {
            BeanUtils.copyProperties(user, new User());
            Boolean check= iUserService.createUser(user);
            redirectAttributes.addFlashAttribute("check", check);
        }
        return "redirect:/result";
    }
}
