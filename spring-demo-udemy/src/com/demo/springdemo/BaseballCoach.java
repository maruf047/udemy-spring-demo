package com.demo.springdemo;

public class BaseballCoach implements Coach {

//    Define a private field for the dependency
    private FortuneService fortuneService;

//    Define a constructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {

//        Use my fortuneService to get fortune
        return fortuneService.getFortune();
    }

}
