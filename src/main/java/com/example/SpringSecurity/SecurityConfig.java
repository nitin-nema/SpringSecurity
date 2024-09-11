package com.example.SpringSecurity;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
// OAuth2 psudo code for security config

protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/","/login").permitAll()
            .anyRequest().authenticated() // protect all other routes
            .and()
            .oauth2Login() // Enabling OAtuth2 login
            .defaultSuccessUrl("/dashboard",true); // redirect to dashboard on successful login
}