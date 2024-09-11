package com.example.SpringSecurity;

public class OtpAuthenticationToken extends AbstractAuthenticationToken {

    private final String username;
    private final String otp;

    public OtpAuthenticationToken(String username, String otp) {
        super(null);
        this.username = username;
        this.otp = otp;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return otp;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }
}
