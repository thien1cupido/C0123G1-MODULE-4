package com.example.bai_1.service.impl;

import com.example.bai_1.service.ICurrencyConversionService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {
    @Override
    public float conversionMoney(int number1, int number2) {
        return number1*number2;
    }
}
