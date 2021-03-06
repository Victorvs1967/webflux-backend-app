package com.vvs.webfluxbackendapp.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class HealthRouter {
  
  @Bean
  public RouterFunction<ServerResponse> healthRouterFunction(HealthHendler healthHendler) {
    return RouterFunctions
      .route(GET("/health").and(accept(APPLICATION_JSON)), healthHendler::check);
  }

}
