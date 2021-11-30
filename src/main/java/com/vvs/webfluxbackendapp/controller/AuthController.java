package com.vvs.webfluxbackendapp.controller;

// import com.vvs.webfluxbackendapp.entity.dto.ResponseDto;
// import com.vvs.webfluxbackendapp.entity.dto.UserDto;
import com.vvs.webfluxbackendapp.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
// import reactor.core.publisher.Mono;

@Log4j2
// @RestController
// @RequestMapping("/auth")
public class AuthController {
  
  @Autowired
  private AuthService authService;

  // @PostMapping("signup")
  // public Mono<UserDto> signup(@RequestBody UserDto userDto) {
  //   return authService.signup(userDto);
  // }

  // @PostMapping("login")
  // public Mono<ResponseDto> signup(@RequestHeader("email") String email, @RequestHeader("password") String password) {
  //   return authService.login(email, password);
  // }
}
