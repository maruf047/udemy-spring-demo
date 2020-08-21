package com.demo.springdemo;

public class TrackCoach implements Coach {

    //    Define a private field for the dependency
    private FortuneService fortuneService;

    public TrackCoach() {
    }

    //    Define a constructor for dependency injection
    public TrackCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

//    Add an init method

    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

//    Add a destroy method

    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }
}
