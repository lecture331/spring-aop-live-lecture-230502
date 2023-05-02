package com.example.springaoplivelecture230502.course;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * com.example.springaoplivelecture230502.course.CourseService.save*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before executing: " + joinPoint.getSignature().getName());
    }

    @After("execution(public * com.example.springaoplivelecture230502.course.CourseService.save*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("After executing: " + joinPoint.getSignature().getName());
    }

    @Around("execution(public * com.example.springaoplivelecture230502.course.CourseService.get*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around - Before executing: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        log.info("Around - After executing: " + joinPoint.getSignature().getName());
        return result;
    }

    @AfterReturning(pointcut = "execution(public * com.example.springaoplivelecture230502.course.CourseService.delete*(*))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("After returning from " + joinPoint.getSignature().getName() + " with result: " + result);
    }

    @AfterThrowing(pointcut = "execution(public * com.example.springaoplivelecture230502.course.CourseService.delete*(*))",
            throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        log.error("After throwing from " + joinPoint.getSignature().getName() + " with exception: " + exception.getMessage());
    }

}