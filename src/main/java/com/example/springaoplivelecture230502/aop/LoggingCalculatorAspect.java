package com.example.springaoplivelecture230502.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class LoggingCalculatorAspect {

    @Before("execution(public * com.example.springaoplivelecture230502.aop.CalculatorAopImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before " + joinPoint.getSignature().getName() + " method");
        log.info("Start Operate");
    }

    @AfterReturning(value = "execution(public * com.example.springaoplivelecture230502.aop.CalculatorAopImpl.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("After " + joinPoint.getSignature().getName() + " method");
        log.info("Result : " + result);
    }
}