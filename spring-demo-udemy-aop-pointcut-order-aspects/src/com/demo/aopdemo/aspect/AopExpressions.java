package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.demo.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    //    Create pointcut for getter methods
    @Pointcut("execution(* com.demo.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    //    Create pointcut for setter methods
    @Pointcut("execution(* com.demo.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    //    Create pointcut: include package ... exclude getter/setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }

}
