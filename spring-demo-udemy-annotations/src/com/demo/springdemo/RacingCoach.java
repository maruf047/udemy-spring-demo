package com.demo.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RacingCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice cornering";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
