package com.trivera.msvc_customer.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import com.trivera.msvc_customer.dto.CustomerDTO;
import com.trivera.msvc_customer.utils.IMapper;

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
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity implements IMapper<CustomerDTO> {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false, unique = true, length = 20)
  private String cbu;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 150)
  private String address;

  @Column(nullable = false, length = 100)
  private String email;

  @Column(nullable = false, length = 20)
  private String mobile;

  @Override
  public CustomerDTO getDTO() {
    return CustomerDTO.builder()
              .id(id)
              .cbu(cbu)
              .name(name)
              .address(address)
              .email(email)
              .mobile(mobile)
              .build();
  }

  @Override
  public void setDTO(CustomerDTO t) {
    this.id = t.getId();
    this.cbu = t.getCbu();
    this.name = t.getName();
    this.address = t.getAddress();
    this.email = t.getEmail();
    this.mobile = t.getMobile();
  }

}
