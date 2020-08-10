package com.memsource.demotestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan("com.memsource.demotestproject.config")
@EnableJpaRepositories
public class DemoTestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTestProjectApplication.class, args);
    }

}
