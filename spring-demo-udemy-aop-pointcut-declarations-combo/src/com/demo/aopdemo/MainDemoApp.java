package com.demo.aopdemo;

import com.demo.aopdemo.dao.AccountDao;
import com.demo.aopdemo.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

//        Read Spring config java class
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

//        Get the bean from Spring container
        AccountDao theAccountDao = configApplicationContext
                .getBean(
                        "accountDao",
                        AccountDao.class
                );

//        Get the bean from Spring container
        MembershipDao theMembershipDao = configApplicationContext
                .getBean(
                        "membershipDao",
                        MembershipDao.class
                );

//        Call the business method
        Account myAccount = new Account();
        theAccountDao.addAccount(myAccount, true);
        theAccountDao.doWork();

//        Call account  getter/setter methods
        theAccountDao.setName("foobar");
        theAccountDao.setServiceCode("silver");

        String name = theAccountDao.getName();
        String serviceCode = theAccountDao.getServiceCode();

        theMembershipDao.addSillyMember();
        theMembershipDao.goToSleep();

//        Close the context
        configApplicationContext.close();
    }
}
