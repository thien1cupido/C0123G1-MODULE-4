package com.example.currency_conversion.controller;

import com.example.currency_conversion.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CurrencyConversionController {
    @GetMapping("/")
    public String getCurrencyConversion() {
        return "currency_conversion";
    }
    @Autowired
    private ICurrencyConversionService conversionMoney;

    @GetMapping("/currency")
    public String getCurrencyConversion(Model model, @RequestParam(value = "inputMoney",defaultValue = "0") Integer inputMoney, @RequestParam(value = "exchangeRate",defaultValue = "0") Integer exchangeRate) {
        int result = conversionMoney.conversionMoney(inputMoney,exchangeRate);
        model.addAttribute("result", "Kết quả: "+result+"VNĐ");
        return "currency_conversion";
    }
}
