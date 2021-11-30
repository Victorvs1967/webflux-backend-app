package com.vvs.webfluxbackendapp.entity.dto;

import lombok.Data;

@Data
public class RequestDto {
  
  private String password;
  private String firstName;
  private String lastName;
  private String phone;
  private String email;
}
