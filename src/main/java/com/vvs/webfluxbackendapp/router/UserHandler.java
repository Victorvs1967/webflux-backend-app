package com.vvs.webfluxbackendapp.router;

import com.vvs.webfluxbackendapp.entity.dto.UserDto;
import com.vvs.webfluxbackendapp.security.JWTUtil;
import com.vvs.webfluxbackendapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Log4j2
@Component
public class UserHandler {
  
  @Autowired
  private UserService userService;
  @Autowired
  private JWTUtil jwtUtil;

  public Mono<ServerResponse> getUser(ServerRequest request) {
    String token = request.headers().firstHeader("authorization").substring(7);
    
    Mono<?> response = jwtUtil.getAllClaimsFromToken(token)
      .flatMap(credentials -> userService.getUser(credentials.getSubject()).cast(UserDto.class)
        .map(userDetails -> userDetails));

    return ServerResponse
      .ok()
      .contentType(APPLICATION_JSON)
      .body(response, UserDto.class);
  }
}
