package com.example.SpringSecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class CustomSecurityConfig {
}


@Autowired
private CustomAuthenticationProvider customAuthenticationProvider;


@Override
protected void configure(AuthenticationManagerBuilder auth) throws  Exception{
    auth.authenticationProvider(customAuthenticationProvider);
}

@Override
protected void configure(HttpSecurity http) throws Exception{
    http.csrf().disable()
       .authorizeRequests()
            .antMathcer("/api/auith/**").permitAll()
            .anyRequest().authenticated();
}