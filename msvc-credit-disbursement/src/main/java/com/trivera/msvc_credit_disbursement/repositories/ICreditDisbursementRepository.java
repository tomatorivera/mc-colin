package com.trivera.msvc_credit_disbursement.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trivera.msvc_credit_disbursement.entities.CreditDisbursementEntity;

@Repository
public interface ICreditDisbursementRepository extends JpaRepository<CreditDisbursementEntity, UUID> {
}
