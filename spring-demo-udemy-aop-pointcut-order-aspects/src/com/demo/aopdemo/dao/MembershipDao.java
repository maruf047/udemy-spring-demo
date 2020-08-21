package com.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public boolean addSillyMember()
    {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");

        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": Going to sleep()");
    }

}
