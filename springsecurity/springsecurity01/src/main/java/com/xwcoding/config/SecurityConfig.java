package com.xwcoding.config;

import com.xwcoding.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author liuxiaowei
 * @description
 * @date 2020/10/21 10:20
 */
@Configuration
@EnableWebSecurity

//  拦截注解了@PreAuthrize注解的配置
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/user").hasRole("USER")   //USER 角色设置必须在 ADMIN 前面
//                .antMatchers("/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder());
                /*.inMemoryAuthentication()
                .withUser("admin")  //管理员，拥有 ADMIN 和 USER 权限，可以访问所有资源
                .password("{noop}admin")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}user") //普通用户，拥有 USER 权限，可以访问部分资源
                .roles("USER");*/
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String user = bCryptPasswordEncoder.encode("user");
        String admin = bCryptPasswordEncoder.encode("admin");
        System.out.println(user);
        System.out.println(admin);
    }
}
