package com.memsource.demotestproject.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties("memsource")
public class MemsourceConfig {
    private String baseUrl;
    private String loginUrl;
    private String projectsUrl;
    private Login login;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Login {
        private String username;
        private String password;
    }
}
