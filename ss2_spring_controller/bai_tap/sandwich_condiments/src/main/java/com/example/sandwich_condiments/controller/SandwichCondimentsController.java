package com.example.sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {
    @GetMapping("/")
    public String redirectSandwichCondiments(){
        return "sandwich_condiments";
    }
    @PostMapping("/sandwich")
    public String getSpice(Model model,@RequestParam String[] spice){
        model.addAttribute("spiceArray",spice);
        return "sandwich_condiments";
    }
}
