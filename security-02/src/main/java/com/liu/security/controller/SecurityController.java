package com.liu.security.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-06-25 - 13:55
 */

@RestController
public class SecurityController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("server/port")
    public String getServerPort(){
        return serverPort;
    }

    // 指定normal和admin角色都可以访问的方法
    @RequestMapping("/hello")
    @PreAuthorize(value = "hasAnyRole('admin', 'normal')")
    public String hello(){
        return "hello, normal and admin!!!";
    }

    // admin专属访问通道
    // @PreAuthorize: 访问方法之前进行验证用户是由拥有当前指定的角色
    @RequestMapping("/admin")
    @PreAuthorize(value = "hasRole('admin')")
    public String admin(){
        return "该方法只有admin角色的用户才可以访问!";
    }




}
