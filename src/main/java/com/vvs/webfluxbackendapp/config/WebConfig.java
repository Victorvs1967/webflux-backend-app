package com.vvs.webfluxbackendapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
  
  @Override
  public void addCorsMappings(CorsRegistry registry) { 
    registry.addMapping("/**")
      .allowedOrigins("http://localhost:4200")
      .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
      .allowCredentials(true)
      .maxAge(3600);
  }
}
