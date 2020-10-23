package com.xwcoding.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @description
 * @date 2020/10/20 17:00
 */
@RestController
@RequestMapping("/")
public class HelloController {

    // 拥有 USER 或者 ADMIN 角色
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringSecurity!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    // @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/admin")
    public String admin() {
        return "Hello Admin 角色!";
    }

    // 拥有 USER 或者 ADMIN 角色
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    // 同时拥有 USER 和 ADMIN 角色
    // @PreAuthorize("hasRole('USER') and hasRole('ADMIN')")
    @RequestMapping("/user")
    public String user() {
        return "Hello User 角色!";
    }

    // 获取当前登录信息
    @RequestMapping("/userinfo")
    public String getCurrentUserInfo() {
        String currentUser = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            currentUser = ((UserDetails) principal).getUsername();
        } else {
            currentUser = principal.toString();
        }
        return "Hello currentUser是 :" + currentUser;
    }
}
