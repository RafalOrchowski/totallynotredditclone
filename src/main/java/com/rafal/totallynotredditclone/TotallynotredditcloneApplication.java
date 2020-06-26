package com.rafal.totallynotredditclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class TotallynotredditcloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TotallynotredditcloneApplication.class, args);
    }

}
