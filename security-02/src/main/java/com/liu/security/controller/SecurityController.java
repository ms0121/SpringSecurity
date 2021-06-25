package com.liu.security.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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

}
