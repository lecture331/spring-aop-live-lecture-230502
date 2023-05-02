package com.example.springaoplivelecture230502.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTest {

    @Autowired
    private Calculator calculatorProxy;

    @Test
    public void testAddition() {
        double result = calculatorProxy.add(4, 5);
        Assertions.assertEquals(9, result);
    }

    @Test
    public void testSubtraction() {
        double result = calculatorProxy.subtract(15, 9);
        Assertions.assertEquals(6, result);
    }

}
