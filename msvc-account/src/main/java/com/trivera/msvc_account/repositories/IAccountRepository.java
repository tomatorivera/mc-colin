package com.trivera.msvc_account.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trivera.msvc_account.entities.AccountEntity;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, UUID> {

    Optional<AccountEntity> findByNumberAndCustomerCode(String number, String customerCode);
    
}
