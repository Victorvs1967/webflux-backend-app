package com.vvs.webfluxbackendapp.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.vvs.webfluxbackendapp.entity.enums.UserRoles;

import static com.vvs.webfluxbackendapp.entity.enums.UserRoles.MEMBER;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
  
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private String id;
  private String password;
  private String firstName;
  private String lastName;
  private String phone;
  private String email;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UserRoles role = MEMBER;

  public String getFullName() {
    return firstName != null ? firstName.concat(" ").concat(lastName) : "";
  }

}
