package com.san.martin.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  @Qualifier("authenticationManager")

  private AuthenticationManager authenticationManager;

  @Autowired

  private InfoAdicionalToken infoAdicionalToken;

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

    security.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()");
  }
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory().withClient("angularapp")// usuarios
        .secret(passwordEncoder.encode("12345"))// contraseña
        .scopes("read", "write")// permiso
        .authorizedGrantTypes("password", "refresh token")// como vamos a obtener el Token
        .accessTokenValiditySeconds(3600)
        .refreshTokenValiditySeconds(3600);

  }
  

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    TokenEnhancerChain tokenEnhacerChain = new TokenEnhancerChain();
    tokenEnhacerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));
    endpoints.authenticationManager(authenticationManager)
        .tokenStore(tokenStore())
        .accessTokenConverter(accessTokenConverter())
        .tokenEnhancer(tokenEnhacerChain);

  }

  @Bean
  public JwtTokenStore tokenStore() {
    // TODO: Auto-generated method stub
    return new JwtTokenStore(accessTokenConverter());
  }

  @Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
    jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVADA); // firmamos el token jwt
    jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA);// validacion para que el token sea auténtico

    /* nuestra propia llave secreta */
    // jwtAccessTokenConverter.setSigningKey(JwtConfig.LLAVE_SECRETA);
    // jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLIC);
    return jwtAccessTokenConverter;
  }

}
