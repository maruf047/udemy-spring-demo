package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.demo.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

//    Create pointcut for getter methods
    @Pointcut("execution(* com.demo.aopdemo.dao.*.get*(..))")
    private void getter() { }

//    Create pointcut for setter methods
    @Pointcut("execution(* com.demo.aopdemo.dao.*.set*(..))")
    private void setter() { }

//    Create pointcut: include package ... exclude getter/setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n==>> Performing api analytics @Before advice on addAccount()");
    }

}
