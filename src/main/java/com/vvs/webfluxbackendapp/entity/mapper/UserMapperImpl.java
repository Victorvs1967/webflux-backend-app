package com.vvs.webfluxbackendapp.entity.mapper;

import com.vvs.webfluxbackendapp.entity.dto.UserDto;
import com.vvs.webfluxbackendapp.entity.model.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

  @Override
  public UserDto toDTO(User user) {
    UserDto userDto = new UserDto();
    userDto.setPassword(user.getPassword());
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setPhone(user.getPhone());
    userDto.setEmail(user.getEmail());
    return userDto;
  }

  @Override
  public User fromDTO(UserDto userDto) {
    User user = new User();
    user.setPassword(userDto.getPassword());
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setPhone(userDto.getPhone());
    user.setEmail(userDto.getEmail());
    user.setRole(userDto.getRole());
    return user;
  }
  
}
