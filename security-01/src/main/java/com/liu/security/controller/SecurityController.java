package com.liu.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-06-20 - 21:55
 */

@RestController
@RequestMapping("test")
public class SecurityController {

    @GetMapping("hello")
    public String test(){
        return "hello, security!";
    }

    @GetMapping("index")
    public String index(){
        return "welcome to security!";
    }

    /**
     * @Secured:使用当前的注解，必须在主启动进行开启: @EnableGlobalMethodSecurity(securedEnabled = true)
     * @Secured: 判读当前访问的用户是否具有角色，匹配的时候前缀需要加上前缀： "ROLE_"
     * @return
     */
    @GetMapping("update")
    @Secured({"ROLE_role", "ROLE_admin"})
    public String update(){
        return "hello update!";
    }


}
