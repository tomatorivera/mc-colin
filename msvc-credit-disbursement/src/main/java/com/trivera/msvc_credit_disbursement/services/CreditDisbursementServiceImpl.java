package com.trivera.msvc_credit_disbursement.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.trivera.msvc_credit_disbursement.dto.CreditDisbursementDTO;
import com.trivera.msvc_credit_disbursement.repositories.ICreditDisbursementRepository;

@Service
public class CreditDisbursementServiceImpl implements ICreditDisbursementService {

    private final ICreditDisbursementRepository creditRepository;

    public CreditDisbursementServiceImpl(ICreditDisbursementRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public List<CreditDisbursementDTO> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public CreditDisbursementDTO getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public CreditDisbursementDTO save(CreditDisbursementDTO credit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
