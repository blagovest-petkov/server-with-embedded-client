package com.example.serverwithembeddedclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerInitializer {

    public static void run(String[] args) {
        SpringApplication.run(ServerInitializer.class, args);
    }
}
