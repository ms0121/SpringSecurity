package com.liu.security.controller;

import com.liu.security.entity.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-06-20 - 21:55
 */

@Controller
@RequestMapping("test")
public class SecurityController {

    @GetMapping("hello")
    @ResponseBody
    public String test(){
        return "hello, security!";
    }

    @GetMapping("index")
    public String index(){
        return "success";
    }

    /**
     * 方式1：
     * @Secured:使用当前的注解，必须在主启动进行开启: @EnableGlobalMethodSecurity(securedEnabled = true)
     * @Secured: 判读当前访问的用户是否具有角色，匹配的时候前缀需要加上前缀： "ROLE_"
     *
     * 方式2：
     * @PreAuthorize(""): 使用该注解必须开启在主启动prePostEnabled=true，该注解适合在进入方法前进行权限验证，
     *  @PreAuthorize("")可以将登录用户的roles/ permissions参数传到方法中,在方法执行之前进行验证
     *
     * 方式3：
     * @PostAuthorize： 在方法执行之后进行权限验证，适合带有返回值的权限，即先执行方法体，在进行权限判断
     *
     */
    @GetMapping("update")
    @ResponseBody
//    @Secured({"ROLE_role", "ROLE_admin"})
//    @PreAuthorize("hasAuthority('admin')")
    @PostAuthorize("hasAuthority('admin1')")
    public String update(){
        System.out.println("update..............");
        return "hello update!";
    }


    @GetMapping("getAll")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin')")
    // 表示对方法执行之后进行验证，是否符合指定的条件，
    // @PostFilter("filterObject.username == 'aa'")
    // 方法执行之前进行判断，
    @PostFilter("filterObject.id%2==0")
    public List<Users> getAll(){
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(11,"aa", "8989"));
        list.add(new Users(12,"bb", "8080"));
        return list;
    }




}
