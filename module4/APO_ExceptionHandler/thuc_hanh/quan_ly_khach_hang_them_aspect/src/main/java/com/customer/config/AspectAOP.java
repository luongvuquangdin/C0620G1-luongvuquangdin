package com.customer.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class AspectAOP {
    @AfterThrowing(pointcut = "execution(public * com.customer.service.CustomerService.delete(..))",throwing = "e")
    public void login(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String returnType = joinPoint.getSignature().getDeclaringType().getName();
        String methodName = joinPoint.getSignature().getName();
        String argsName = Arrays.toString(joinPoint.getArgs());
        System.err.printf("Error at class: %s  %s.%s.%s: %s", className,
                returnType,
                methodName,
                argsName,
                e.getMessage());
    }
}
