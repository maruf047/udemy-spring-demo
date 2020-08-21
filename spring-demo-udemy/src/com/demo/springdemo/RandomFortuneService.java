package com.demo.springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private List<String> fortunes;

    public RandomFortuneService() {
        this.fortunes = new ArrayList<>();
        this.fortunes.add("Good");
        this.fortunes.add("Day");
        this.fortunes.add("To You");
    }

    public List<String> getFortunes() {
        return fortunes;
    }

    public void setFortunes(List<String> fortunes) {
        this.fortunes = fortunes;
    }

    @Override
    public String getFortune() {
        Random random = new Random();
        return fortunes.get(random.nextInt(this.fortunes.size()));
    }
}
