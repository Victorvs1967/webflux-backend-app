package com.vvs.webfluxbackendapp.service;

import com.vvs.webfluxbackendapp.entity.dto.UserDto;

import reactor.core.publisher.Mono;

public interface UserService {
  Mono<UserDto> getUser(String email);
}
