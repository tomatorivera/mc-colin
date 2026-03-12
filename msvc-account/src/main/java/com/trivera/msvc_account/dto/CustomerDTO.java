package com.trivera.msvc_account.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

  private UUID id;
  private String cbu;
  private String name;
  private String email;
  private String mobile;
  private String address;

}
