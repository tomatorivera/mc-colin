package com.trivera.msvc_customer.services;

import java.util.List;
import java.util.UUID;

import com.trivera.msvc_customer.dto.CustomerDTO;

public interface ICustomerService {
  
  List<CustomerDTO> getAll();
  CustomerDTO getById(UUID id);
  CustomerDTO getByCode(String code);
  CustomerDTO save(CustomerDTO customer);
  void delete(UUID id);

}
