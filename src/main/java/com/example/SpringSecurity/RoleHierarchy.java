package com.example.SpringSecurity;

@Bean
public RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
    String hierarchy = "ROLE_ADMIN > ROLE_USER\nROLE_USER > ROLE_GUEST";
    roleHierarchy.setHierarchy(hierarchy);
    return roleHierarchy;
}

@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasRole("USER")
            .antMatchers("/guest/**").hasRole("GUEST")
            .anyRequest().authenticated()
            .and()
            .formLogin();
}

//ROLE_ADMIN > ROLE_USER
//ROLE_USER > ROLE_GUEST

//admin role- user management,system setting, or viewing sensitive reports
//user - personal account managemnt
//guest -introuductory resources or public content
