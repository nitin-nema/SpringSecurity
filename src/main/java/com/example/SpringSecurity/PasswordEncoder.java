package com.example.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // hashing passsword
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String plainPassword) {
        String hashedPassword = passwordEncoder.encode(plainPassword);
        // Store username and hashedPassword in the database
    }
}
