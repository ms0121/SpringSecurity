package com.liu.security.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author lms
 * @date 2021-06-21 - 10:31
 */
public class Users {

    private Integer id;
    private String Username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
