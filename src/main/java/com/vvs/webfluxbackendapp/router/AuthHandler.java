package com.vvs.webfluxbackendapp.router;

import com.vvs.webfluxbackendapp.entity.dto.ResponseDto;
import com.vvs.webfluxbackendapp.entity.dto.UserDto;
import com.vvs.webfluxbackendapp.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Log4j2
@Component
public class AuthHandler {

  @Autowired
  private AuthService authService;
  
  public Mono<ServerResponse> signup(ServerRequest request) {
    Mono<UserDto> user = request.bodyToMono(UserDto.class)
    .flatMap(credentials -> authService.signup(credentials).cast(UserDto.class)
      .map(userDetails -> userDetails));

    return ServerResponse
        .ok()
        .contentType(APPLICATION_JSON)
        .body(user, UserDto.class);
  }

  public Mono<ServerResponse> login(ServerRequest request) {
    // String email = request.headers().firstHeader("email");
    // String password = request.headers().firstHeader("password");
    
    // Mono<?> response = Mono.just(new Object())
    Mono<?> response = request.bodyToMono(UserDto.class)
      .flatMap(credentials -> authService.login(credentials.getEmail(), credentials.getPassword())).cast(ResponseDto.class)
        .map(userDetails -> userDetails.getData());

    return ServerResponse
      .ok()
      .contentType(APPLICATION_JSON)
      .body(response, ResponseDto.class);
  }

}
