package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.demo.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage() ")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage() ")
    public void performApiAnalytics() {
        System.out.println("\n==>> Performing api analytics @Before advice on addAccount()");
    }

}
