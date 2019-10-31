package com.example.netflixclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NetflixclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixclientApplication.class, args);
    }

}
