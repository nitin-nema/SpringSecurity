package com.example.SpringSecurity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private OtpAuthenticationProvider otpProvider;

    @PostMapping("/generate-otp")
    public ResponseEntity<String> generateOtp(@RequestParam String username) {
        otpProvider.generateOtp(username);
        return ResponseEntity.ok("OTP generated and sent!");
    }
}
