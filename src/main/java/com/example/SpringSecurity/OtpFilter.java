package com.example.SpringSecurity;

public class OtpFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        String username = request.getParameter("username");
        String otp = request.getParameter("otp");

        if (otp != null) {
            OtpAuthenticationToken authRequest = new OtpAuthenticationToken(username, otp);
            return this.getAuthenticationManager().authenticate(authRequest);
        }

        return super.attemptAuthentication(request, response);
    }
}
