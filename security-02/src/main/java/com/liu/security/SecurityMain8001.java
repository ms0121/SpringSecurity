package com.liu.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author lms
 * @date 2021-06-25 - 13:54
 */

// 排除security登录验证的功能
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@SpringBootApplication
public class SecurityMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(SecurityMain8001.class, args);
    }
}
