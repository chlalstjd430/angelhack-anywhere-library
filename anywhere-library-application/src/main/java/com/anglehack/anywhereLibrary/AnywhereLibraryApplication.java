package com.anglehack.anywhereLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.anglehack")
@EntityScan(basePackages = "com.anglehack")
@EnableJpaRepositories(basePackages ="com.anglehack")
@EnableJpaAuditing
public class AnywhereLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnywhereLibraryApplication.class, args);
    }
}
