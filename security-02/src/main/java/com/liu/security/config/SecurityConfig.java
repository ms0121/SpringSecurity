package com.liu.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lms
 * @date 2021-06-25 - 14:32
 *
 * WebSecurityConfigurerAdapter: 控制安全管理的内容
 * 需要做的就是直接继承该类，然后重写方法，实现自定义的信息
 */

@Configuration
// 表示启用springsecurity的安全框架
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pe = passwordEncoder();
        // 在方法中配置 用户名和密码（必须进行加密）的信息，作为登录的数据
        auth.inMemoryAuthentication()
                .withUser("lms").password(pe.encode("123")).roles();
        auth.inMemoryAuthentication()
                .withUser("lisi").password(pe.encode("123")).roles();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 创建PasswordEncoder的实现类，实现类是加密算法
        return new BCryptPasswordEncoder();
    }

}
