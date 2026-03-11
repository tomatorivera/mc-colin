package com.trivera.msvc_customer.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trivera.msvc_customer.dto.CustomerDTO;
import com.trivera.msvc_customer.entities.CustomerEntity;
import com.trivera.msvc_customer.repositories.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

  private final ICustomerRepository customerRepository;

  public CustomerServiceImpl(ICustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CustomerDTO> getAll() {
    return customerRepository.findAll()
                             .stream()
                             .map(CustomerEntity::getDTO)
                             .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerDTO getById(UUID id) {
    Optional<CustomerEntity> optCustomer = customerRepository.findById(id);

    // Todo: throw an exception with a descriptive message
    if (optCustomer.isEmpty())
      return CustomerDTO.builder().build();

    return optCustomer.orElseThrow().getDTO();
  }

  @Override
  @Transactional(readOnly = true)
  public CustomerDTO getByCbu(String cbu) {
    Optional<CustomerEntity> optCustomer = customerRepository.findByCbu(cbu);

    // Todo: throw an exception with a descriptive message
    if (optCustomer.isEmpty())
      return CustomerDTO.builder().build();

    return optCustomer.orElseThrow().getDTO();
  }

  @Override
  @Transactional
  public CustomerDTO save(CustomerDTO customer) {
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setData(customer);

    return customerRepository.save(customerEntity).getDTO();
  }

  @Override
  @Transactional
  public void delete(UUID id) {
    customerRepository.deleteById(id);
  }
  
}
