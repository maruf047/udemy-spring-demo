package com.demo.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.demo.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

//    Define bean for our sad fortune service
    @Bean
    public FortuneService mySadFortuneService() {
        return new SadFortuneService();
    }
//    Define bean for our swim coach and inject dependency
    @Bean
    public Coach mySwimCoach() {
        Coach mySwimCoach = new SwimCoach(mySadFortuneService());
        return mySwimCoach;
    }
}
