package com.example.bai_1.controller;

import com.example.bai_1.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CurrencyConversionController {
    @GetMapping("/")
    public String currencyConversion() {
        return "currency_conversion";
    }
    @Autowired
    private ICurrencyConversionService conversionMoney;

    @GetMapping("/tien_te")
    public String currencyConversion(Model model, @RequestParam(value = "inputMoney",defaultValue = "0") Integer inputMoney, @RequestParam(value = "exchangeRate",defaultValue = "0") Integer exchangeRate) {
        float result = conversionMoney.conversionMoney(inputMoney,exchangeRate);
        model.addAttribute("result", "Kết quả: "+result+"VND");
        return "currency_conversion";
    }
}
