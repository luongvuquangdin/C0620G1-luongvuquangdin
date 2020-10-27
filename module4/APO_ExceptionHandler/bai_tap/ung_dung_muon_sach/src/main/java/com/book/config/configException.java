package com.book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class configException {
    @AfterThrowing(pointcut = "execution(public * com.book.service.BookService.update(..))",throwing = "e")
    public void borrowError(JoinPoint joinPoint,Exception e){
        String argName= Arrays.toString(joinPoint.getArgs());
        System.err.printf("Da het sach %s",argName);
    }
}
