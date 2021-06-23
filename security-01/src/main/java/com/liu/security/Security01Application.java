package com.liu.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

// 排除security的安全验证功能，此时登录就不要进行验证
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Security01Application {

    public static void main(String[] args) {
        SpringApplication.run(Security01Application.class, args);
    }
}
