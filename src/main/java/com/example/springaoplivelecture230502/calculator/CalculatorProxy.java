package com.example.springaoplivelecture230502.calculator;

import org.springframework.stereotype.Service;

@Service
class CalculatorProxy implements Calculator {
    private final Calculator calculatorImpl;

    public CalculatorProxy(Calculator calculatorImpl) {
        this.calculatorImpl = calculatorImpl;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("Before adding " + a + " and " + b);
        int result = calculatorImpl.add(a, b);
        System.out.println("After adding " + a + " and " + b + ", the result is " + result);
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("Before subtracting " + b + " from " + a);
        int result = calculatorImpl.subtract(a, b);
        System.out.println("After subtracting " + b + " from " + a + ", the result is " + result);
        return result;
    }
}
