package com.example.SpringSecurity;

@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret("{noop}clientsecret")  //.secret{bcrypt}
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("read", "write")
                .accessTokenValiditySeconds(3600)  // 1 hour
                .refreshTokenValiditySeconds(86400);  // 24 hours
    }
}


