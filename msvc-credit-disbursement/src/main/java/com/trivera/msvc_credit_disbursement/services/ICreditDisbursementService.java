package com.trivera.msvc_credit_disbursement.services;

import java.util.List;
import java.util.UUID;

import com.trivera.msvc_credit_disbursement.dto.CreditDisbursementDTO;

public interface ICreditDisbursementService {
    
    List<CreditDisbursementDTO> getAll();
    CreditDisbursementDTO getById(UUID id);
    CreditDisbursementDTO add(CreditDisbursementDTO credit);
    void delete(UUID id);

}
