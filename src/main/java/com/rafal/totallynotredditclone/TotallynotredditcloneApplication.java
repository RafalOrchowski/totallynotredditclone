package com.rafal.totallynotredditclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@EnableAsync
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "com.rafal.totallynotredditclone.mapper")

public class TotallynotredditcloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TotallynotredditcloneApplication.class, args);
    }

}
