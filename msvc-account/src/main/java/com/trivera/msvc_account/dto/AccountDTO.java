package com.trivera.msvc_account.dto;

import java.math.BigDecimal;
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
public class AccountDTO {
  
  private UUID id;
  private String number;
  private String name;
  private BigDecimal balance;
  private CustomerDTO customer;

}
