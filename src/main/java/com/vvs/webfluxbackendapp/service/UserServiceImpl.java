package com.vvs.webfluxbackendapp.service;

import com.vvs.webfluxbackendapp.entity.dto.UserDto;
import com.vvs.webfluxbackendapp.entity.mapper.UserMapper;
import com.vvs.webfluxbackendapp.errors.exception.UserNotFoundException;
import com.vvs.webfluxbackendapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;

  @Override
  public Mono<UserDto> getUser(String email) {
    return userRepository.findUserByEmail(email)
            .map(userMapper::toDTO)
            .switchIfEmpty(Mono.error(UserNotFoundException::new));
  }
  
}
