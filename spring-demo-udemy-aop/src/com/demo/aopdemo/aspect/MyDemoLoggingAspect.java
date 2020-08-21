package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    This is where we add all of our related advices for logging

//    Let's start with and @Before advice

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.demo.aopdemo.dao.AccountDao.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*(com.demo.aopdemo.Account))")
//    @Before("execution(* add*(com.demo.aopdemo.Account, ..))")
//    @Before("execution(* add*(..))")
    @Before("execution(* com.demo.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==>> Executing @Before advice on addAccount()");
    }

}
