package com.example.config_email.controller;

import com.example.config_email.model.ConfigEmail;
import com.example.config_email.service.IConfigEmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ConfigEmailController {
    @Autowired
    private IConfigEmailService configEmailService;

    @GetMapping("/")
    public String viewConfigEmail(Model model) {
        String[] language = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        Integer[] pageSizes = new Integer[]{5, 10, 15, 20, 25, 50, 100};
        ConfigEmail configEmail = configEmailService.getConfigEmail();
        model.addAttribute("language", language);
        model.addAttribute("pageSizes", pageSizes);
        model.addAttribute("configEmail", configEmail);
        return "config_form";
    }

    @PostMapping("/updateConfig")
    public String updateConfigEmail(@ModelAttribute("configEmail") ConfigEmail configEmail, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        configEmailService.updateConfigEmail(configEmail);
        ConfigEmail configEmail1=configEmailService.getConfigEmail();
        BeanUtils.copyProperties(configEmail,configEmail1);
        return "updated_email";
    }
}
