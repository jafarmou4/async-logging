package com.example.async;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class Initializer implements CommandLineRunner {
    List<String> loggableAPIs = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        Stream.of("getById", "createStudent").forEach(loggableAPIs::add);
    }

    public List<String> getLoggableAPIs() {
        return loggableAPIs;
    }
}
