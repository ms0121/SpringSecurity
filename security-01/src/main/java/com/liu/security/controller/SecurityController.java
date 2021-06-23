package com.liu.security.controller;

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

}
