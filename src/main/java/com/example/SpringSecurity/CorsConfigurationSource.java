package com.example.SpringSecurity;

@Override
protected void configure(HttpSecurity http) throws Exception {
    http.cors().configurationSource(corsConfigurationSource()).and().csrf().disable();
}

@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("https://trusted-domain.com"));  // Trusted domains
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));  // Allowed methods
    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));  // Allowed headers
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
}

//
//https://frontend-app.com
//https://api-backend.cpm