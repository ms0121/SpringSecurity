package com.liu.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-21 - 9:38
 *
 * 方式三： 自定义编写实现类的方式实现用户名和密码的设置
 * 实现的步骤：
 *      1. 创建配置类，设置使用哪个UserDetailsService的实现类
 *      2. 编写实现类，返回User对象，User对象有用户名密码和操作权限的设置
 *
 */
@Configuration
public class SecurityConfigUser extends WebSecurityConfigurerAdapter {

    // 将service中自定义的UserDetailsService实现类进行注入
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    // 密码加密对象的实现类
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 自定义登录页面
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 配置没有访问权限跳转到指定的自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");

        http.formLogin() // 表示使用自定义的登录页面
                .loginPage("/login.html")  // 登录页面
                // login.html页面提交数据的访问地址
                .loginProcessingUrl("/user/login") // 登录页面提交表单的请求地址(也就是把表单数据提交到哪里)
                .defaultSuccessUrl("/test/index").permitAll() // 登陆成功之后，跳转到该路径，并具有所有的权限
                .and().authorizeRequests()  // 授权请求设置

                // 方式1： hasAuthority()方法
                // 表示当前登录的用户，只有具有admin角色权限才可以访问这个地址，
                // hasAuthority角色权限设置在UserDetailsService里面(针对的是单个角色的设置)
//                .antMatchers("/test/index").hasAuthority("admins")


                // 方式2：hasAnyAuthority(),表示可以有多个角色权限中的任何一个都可以进行访问
//                .antMatchers("/test/index").hasAnyAuthority("admins, admin")
//                .anyRequest().authenticated()

                // 方式3：hasRole(),表示当前访问的用户具有 “ROLE_”开头的角色，源码要求必须以 ROLE_，如：ROLE_role
//                .antMatchers("/test/index").hasRole("role")

                // 方式4:hasAnyRole("role")，有其中的任意一个角色即可
                .antMatchers("/test/index").hasAnyRole("role")
                .and().csrf().disable();  // 关闭csrf防护


//                设置哪些访问路径不用登录页也可以直接查看
//                .antMatchers("/", "/test/hello","/user/login").permitAll()

    }
}














