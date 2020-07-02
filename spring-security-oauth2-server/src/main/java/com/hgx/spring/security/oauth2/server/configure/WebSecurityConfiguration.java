package com.hgx.spring.security.oauth2.server.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hgx
 * @date 2020/7/2 16:50
 * @Description
 */

@Configuration
@EnableWebSecurity
//拦截所有请求
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    //密码加密方式
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存当中创建两个用户
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("12456"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin888"))
                .roles("ADMIN");

    }
}
