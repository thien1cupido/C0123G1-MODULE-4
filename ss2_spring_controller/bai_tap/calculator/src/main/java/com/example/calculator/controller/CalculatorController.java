package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getCalculator() {
        return "calculator";
    }
    @Autowired
    ICalculatorService calculatorService;
    @GetMapping("/calculate")
    public String displayCalculator(Model model, @RequestParam(value = "number1",defaultValue = "0") Integer number1,
                                    @RequestParam(value = "number2",defaultValue = "0") Integer number2, @RequestParam("operation")String operation) {
        String result="Result "+operation+": "+calculatorService.getResult(number1,number2,operation);
        model.addAttribute("result",result);
        return "calculator";
    }
}
