package com.vvs.webfluxbackendapp.service;

import com.vvs.webfluxbackendapp.entity.dto.ResponseDto;
import com.vvs.webfluxbackendapp.entity.dto.UserDto;

import reactor.core.publisher.Mono;

public interface AuthService {
  Mono<UserDto> signup(UserDto userDto);
  Mono<ResponseDto> login(String email, String password);
}
