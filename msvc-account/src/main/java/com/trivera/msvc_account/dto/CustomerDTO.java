package com.trivera.msvc_account.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

  private UUID id;
  private String code;
  private String name;
  private String email;
  private String mobile;
  private String address;

}
