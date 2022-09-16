package com.dgryzhkov.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 * @author Dgryzhkov
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(userBuilder.username("Denis").password("denis").roles("EMPLOYEE"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("Elena").password("elena").roles("HR"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("Ivan").password("ivan").roles("MANAGER", "HR"));
    }
}
