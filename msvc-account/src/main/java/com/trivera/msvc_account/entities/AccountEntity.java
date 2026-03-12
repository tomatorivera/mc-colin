package com.trivera.msvc_account.entities;

import java.math.BigDecimal;
import java.util.UUID;

import com.trivera.msvc_account.dto.AccountDTO;
import com.trivera.msvc_account.dto.CustomerDTO;
import com.trivera.msvc_account.utils.IMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
public class AccountEntity implements IMapper<AccountDTO> {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false, unique = true, length = 13)
  private String number;

  @Column(nullable = false, length = 60)
  private String name;

  @Column(precision = 10, scale = 2)
  private BigDecimal balance;

  @Column(name = "customer_code", nullable = false, length = 20)
  private String customerCode;

  @Override
  public AccountDTO getDTO() {
    return AccountDTO.builder()
              .id(id)
              .number(number)
              .name(name)
              .balance(balance)
              .customer(
                CustomerDTO.builder()
                    .cbu(customerCode)
                    .build()
              ) 
              .build();
  }

  @Override
  public void setData(AccountDTO t) {
    this.id = t.getId();
    this.number = t.getNumber();
    this.name = t.getName();
    this.balance = t.getBalance();
    this.customerCode = t.getCustomer().getCbu();
  }
  
}
