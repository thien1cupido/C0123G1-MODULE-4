package com.example.blogging_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BloggingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggingAppApplication.class, args);
    }

}
