package com.example.bai_2.controller;

import com.example.bai_2.service.ISimpleDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleDictionaryController {
    @Autowired
    private ISimpleDictionaryService simpleDictionaryService;

    @GetMapping("/")
    public String dictionaryController(){
        return "simple_dictionary";
    }
    @GetMapping("/simple_dictionary")
    public String dictionaryController(Model model, @RequestParam(value = "search")String inputSearch){
        String string= simpleDictionaryService.getResultSearch(inputSearch);
        model.addAttribute("result",string);
        return "simple_dictionary";
    }
}
