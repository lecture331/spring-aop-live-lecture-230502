package com.example.springaoplivelecture230502.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
