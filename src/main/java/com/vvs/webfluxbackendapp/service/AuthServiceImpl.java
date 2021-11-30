package com.vvs.webfluxbackendapp.service;

import com.vvs.webfluxbackendapp.entity.dto.ResponseDto;
import com.vvs.webfluxbackendapp.entity.dto.UserDto;
import com.vvs.webfluxbackendapp.entity.mapper.UserMapper;
import com.vvs.webfluxbackendapp.errors.exception.UserAlreadyExistException;
import com.vvs.webfluxbackendapp.errors.exception.WrongCredentialException;
import com.vvs.webfluxbackendapp.repository.UserRepository;
import com.vvs.webfluxbackendapp.security.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class AuthServiceImpl implements AuthService {
  
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JWTUtil jwtUtil;
  @Autowired
  private UserMapper userMapper;

  @Override
  public Mono<UserDto> signup(UserDto userDto) {
    return isUserExist(userDto.getEmail())
            .filter(userExist -> !userExist)
            .switchIfEmpty(Mono.error(UserAlreadyExistException::new))
            .map(aBoolean -> userDto)
            .map(userMapper::fromDTO)
            .doOnNext(user -> user.setPassword(passwordEncoder.encode(user.getPassword())))
            .flatMap(userRepository::save)
            .map(userMapper::toDTO);
  }

  @Override
  public Mono<ResponseDto> login(String email, String password) {
    return userRepository.findByEmail(email)
            .filter(userDetails -> passwordEncoder.matches(password, userDetails.getPassword()))
            .map(userDetails -> jwtUtil.generateToken(userDetails))
            .map(token -> ResponseDto.builder().data(token).build())
            .switchIfEmpty(Mono.error(WrongCredentialException::new));
  }

  private Mono<Boolean> isUserExist(String email) {
    return userRepository.findByEmail(email)
            .map(user -> true)
            .switchIfEmpty(Mono.just(false));
  }
}
