package com.example.netflixclient.feigntest;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level  feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
