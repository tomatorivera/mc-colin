package com.trivera.msvc_customer.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trivera.msvc_customer.entities.CustomerEntity;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, UUID> {
  
  Optional<CustomerEntity> findByCode(String code);

}
