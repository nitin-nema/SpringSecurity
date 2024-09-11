package com.example.SpringSecurity;

@EnableWebSecurity
public class LdapSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")  // Pattern to locate users
                .groupSearchBase("ou=groups")  // Base DN(Distinguished name) for groups
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")  // LDAP server URL
                .and()
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())  // Password encoder
                .passwordAttribute("userPassword");  // LDAP attribute for password
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }
}
