package com.example.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableAsync
public class AsyncLoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncLoggingApplication.class, args);
    }

//    @Bean
//    public Executor asyncExecutor() {
//        return Executors.newFixedThreadPool(12);
//    }
}
