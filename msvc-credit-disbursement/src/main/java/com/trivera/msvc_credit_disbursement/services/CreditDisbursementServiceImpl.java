package com.trivera.msvc_credit_disbursement.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trivera.msvc_credit_disbursement.clients.IAccountRESTClient;
import com.trivera.msvc_credit_disbursement.dto.AccountDTO;
import com.trivera.msvc_credit_disbursement.dto.CreditDisbursementDTO;
import com.trivera.msvc_credit_disbursement.dto.DepositDTO;
import com.trivera.msvc_credit_disbursement.entities.CreditDisbursementEntity;
import com.trivera.msvc_credit_disbursement.repositories.ICreditDisbursementRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CreditDisbursementServiceImpl implements ICreditDisbursementService {

    private final ICreditDisbursementRepository creditRepository;
    private final IAccountRESTClient accountClient;

    public CreditDisbursementServiceImpl(ICreditDisbursementRepository creditRepository, IAccountRESTClient accountClient) {
        this.creditRepository = creditRepository;
        this.accountClient = accountClient;
    }

    @Override
    @Transactional(readOnly = true)
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
    public CreditDisbursementDTO add(CreditDisbursementDTO credit) {
        log.info("Add credit request: " + credit);

        ResponseEntity<AccountDTO> responseDeposit = accountClient.depositAccount(
            DepositDTO.builder()
                .accountNumber(credit.getAccountNumber())
                .amount(credit.getAmount())
                .customerCode(credit.getCustomerCode())
                .build()
        );

        // TODO throw an exception with a descriptive message
        if (!responseDeposit.getStatusCode().is2xxSuccessful())
        {
            log.error("Fail depositing into account - STATUS CODE: " + responseDeposit.getStatusCode().value());
            return CreditDisbursementDTO.builder().build();
        }

        CreditDisbursementEntity creditEntity = new CreditDisbursementEntity();
        creditEntity.setData(credit);
        
        creditRepository.save(creditEntity);
        log.info("Credit added: " + creditEntity);
        return creditEntity.getDTO();
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
