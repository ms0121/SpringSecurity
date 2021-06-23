package com.liu.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lms
 * @date 2021-06-21 - 8:22
 */

/**
 方式二：使用配置类的方式实现security的用户名和密码的设置
 */
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 修改

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 创建密码加密功能的对象（前提必须在IOC容器中注入相应的密码加密的对象）
//        PasswordEncoder passwordEncoder = passwordEncoder();  // 直接获取下面实现类的返回值对象
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 给登录密码进行加密的设置
        String password = passwordEncoder.encode("123");
        // 设置用户名和密码，以及给当前的用户设置权限
        auth.inMemoryAuthentication().withUser("lucy").password(password).roles("admin");
    }

    /**
     * 密码加密的实现类注入到容器中，因为5.0版本之后的 security必须对密码进行加密，否则执行程序将会出错
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        // BCryptPasswordEncoder是跨平台的加密实现类
        return new BCryptPasswordEncoder();
    }


}













