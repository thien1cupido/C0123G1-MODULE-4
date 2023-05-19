package com.example.currency_conversion.service.impl;

import com.example.currency_conversion.service.ICurrencyConversionService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {
    @Override
    public int conversionMoney(int number1, int number2) {
        return number1*number2;
    }
}
