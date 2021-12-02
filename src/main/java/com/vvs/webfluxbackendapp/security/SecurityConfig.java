package com.vvs.webfluxbackendapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
public class SecurityConfig {
  
  private static final String[] WHITELISTED_AUTH_URLS = {"/auth/signup", "/auth/login"};

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private SecurityContextRepository securityContextRepository;

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http
            .cors().configurationSource(createCorsConfigurationSource()).and()
            .exceptionHandling()
            .authenticationEntryPoint((shs, e) -> Mono.fromRunnable(() -> {
              shs.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            })).accessDeniedHandler((shs, e) -> Mono.fromRunnable(() -> {
              shs.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            })).and()
            .csrf().disable()
            .formLogin().disable()
            .authenticationManager(authenticationManager)
            .securityContextRepository(securityContextRepository)
            .authorizeExchange()
            .pathMatchers(HttpMethod.OPTIONS).permitAll()
            .pathMatchers(WHITELISTED_AUTH_URLS).permitAll()
            .anyExchange().authenticated()
            .and().build();
  }

  public CorsConfigurationSource createCorsConfigurationSource() {
    
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();

    config.setAllowCredentials(true);
    config.addAllowedOrigin("http://localhost:4200");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");

    source.registerCorsConfiguration("/**", config);

    return source;
  }
}
