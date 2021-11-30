package com.vvs.webfluxbackendapp.controller;

import java.security.Principal;

import com.vvs.webfluxbackendapp.entity.dto.UserDto;
import com.vvs.webfluxbackendapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

// @RestController
// @RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  // @GetMapping
  // public Mono<UserDto> getUser(Principal principal) {
  //   return userService.getUser(principal.getName());
  // }
  
}
