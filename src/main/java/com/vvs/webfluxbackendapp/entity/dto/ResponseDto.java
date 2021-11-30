package com.vvs.webfluxbackendapp.entity.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto {
  private Object data;
}
