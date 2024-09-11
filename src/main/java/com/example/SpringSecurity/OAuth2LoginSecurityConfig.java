package com.example.SpringSecurity;

@EnableWebSecurity
public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login()
                .loginPage("/oauth2/authorization/google") // Custom OAuth2 login page
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error=true")
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/oauth2/**").permitAll()
                .anyRequest().authenticated();
    }
}
