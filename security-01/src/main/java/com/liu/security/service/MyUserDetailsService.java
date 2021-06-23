package com.liu.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liu.security.entity.Users;
import com.liu.security.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-06-21 - 9:42
 */

@Service

public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询数据库中的数据信息
        // QueryWrapper: 用于拼接wehere之后的条件查询语句
        QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>();
        // where username = ?, 判断
        queryWrapper.eq("username", username);
        Users users = userMapper.selectOne(queryWrapper);

        // 判断用户是否存在，
        if (users == null){    // 认证失败
            throw new UsernameNotFoundException("用户名不存在!");
        }

        // 用户角色列表
        List<GrantedAuthority> role =
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin, ROLE_role1");
        /**
         * 参数1：用户名
         * 参数2：密码加密
         * 参数3：用户角色列表
         */
        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()),role);
    }
}
