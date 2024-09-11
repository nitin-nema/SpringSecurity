package com.example.SpringSecurity;

@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {

    // Simulate OTP storage (In a real-world scenario, this would be stored temporarily in a database or cache)
    private final Map<String, String> otpStorage = new HashMap<>();

    // Store OTP for users (In practice, send OTP to user's phone or email)
    public void generateOtp(String username) {
        String otp = String.valueOf(new Random().nextInt(999999)); // Generate 6-digit OTP
        otpStorage.put(username, otp);
        System.out.println("Generated OTP for " + username + ": " + otp);  // Simulate sending OTP
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String otp = authentication.getCredentials().toString();

        // OTP verification logic
        if (otpStorage.containsKey(username) && otpStorage.get(username).equals(otp)) {
            otpStorage.remove(username);  // OTP is one-time, remove after use
            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
        } else {
            throw new BadCredentialsException("Invalid OTP");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OtpAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
