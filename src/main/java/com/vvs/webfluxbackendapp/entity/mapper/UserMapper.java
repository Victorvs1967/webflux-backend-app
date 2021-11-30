package com.vvs.webfluxbackendapp.entity.mapper;

import com.vvs.webfluxbackendapp.entity.dto.UserDto;
import com.vvs.webfluxbackendapp.entity.model.User;

public interface UserMapper {
  
  UserDto toDTO(final User user);
  User fromDTO(final UserDto userDto);
}
