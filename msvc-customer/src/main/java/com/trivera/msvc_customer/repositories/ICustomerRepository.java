package com.trivera.msvc_customer.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trivera.msvc_customer.entities.CustomerEntity;

@Repository
public interface ICustomerRepository extends CrudRepository<CustomerEntity, UUID> {
  
  Optional<CustomerEntity> findByCbu(String cbu);

}
