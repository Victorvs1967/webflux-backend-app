package com.vvs.webfluxbackendapp.router;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class HealthHendler {
  
  public Mono<ServerResponse> check(ServerRequest request) {
    return ServerResponse
      .ok()
      .body(Mono.just("UP"), String.class);
  }
}
