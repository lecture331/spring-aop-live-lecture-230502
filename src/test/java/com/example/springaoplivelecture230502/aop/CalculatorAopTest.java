package com.example.springaoplivelecture230502.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorAopTest {

    @Autowired
    private Calculator calculatorAopImpl;

    @Test
    public void testAddition() {
        double result = calculatorAopImpl.add(10, 5);
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        double result = calculatorAopImpl.subtract(10, 5);
        assertEquals(5, result);
    }

    @Test
    public void testMultiplication() {
        double result = calculatorAopImpl.multiply(10, 5);
        assertEquals(50, result);
    }

    @Test
    public void testDivision() {
        double result = calculatorAopImpl.divide(10, 5);
        assertEquals(2, result);
    }
}