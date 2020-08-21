package com.demo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach: Inside default constructor");
    }

    /*@Autowired
    public TennisCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }*/

//    Define setter method

//    @Autowired
//    public void setFortuneService(FortuneService theFortuneService) {
//        System.out.println(">> TennisCoach: Inside setFortuneService setter method");
//        this.fortuneService = theFortuneService;
//    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService theFortuneService) {
//        System.out.println(">> TennisCoach: Inside doSomeCrazyStuff setter method");
//        this.fortuneService = theFortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    Define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">>TennisCoach: Inside of doMyStartupStuff");
    }

//    Define my init method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">>TennisCoach: Inside of doMyCleanupStuff");
    }

}
