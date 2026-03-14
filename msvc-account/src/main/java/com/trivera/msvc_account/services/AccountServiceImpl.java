package com.trivera.msvc_account.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trivera.msvc_account.clients.ICustomerRESTClient;
import com.trivera.msvc_account.dto.AccountDTO;
import com.trivera.msvc_account.dto.CustomerDTO;
import com.trivera.msvc_account.dto.DepositDTO;
import com.trivera.msvc_account.entities.AccountEntity;
import com.trivera.msvc_account.repositories.IAccountRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AccountServiceImpl implements IAccountService {

    private final IAccountRepository accountRepository;
    private ICustomerRESTClient customerClient;

    public AccountServiceImpl(IAccountRepository accountRepository, ICustomerRESTClient customerClient) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountDTO> getAll() {
        return accountRepository.findAll().stream().map(AccountEntity::getDTO).toList();
    }

    @Override
    @Transactional
    public AccountDTO save(AccountDTO account) {
        ResponseEntity<CustomerDTO> responseAddCustomer = customerClient.add(account.getCustomer());

        // Todo: throw an exception with a descriptive message
        if (!responseAddCustomer.getStatusCode().is2xxSuccessful())
        {
            log.error("An error ocurred creating the customer - STATUS CODE {}", responseAddCustomer.getStatusCode());
            return AccountDTO.builder().build();
        }
        
        // Todo: undo the customer creation if there is an error creating the account
        // Posible solutions: using SAGA pattern or Event Driven Architecture
        log.info("Customer added successfully: {}", account.getCustomer());
        account.setCustomer(responseAddCustomer.getBody());

        log.info((account.getId() != null)
                ? "Updating account: " + account
                : "Creating account: " + account);

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setData(account);

        return accountRepository.save(accountEntity).getDTO();
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        log.warn("Deleting account - id {}", id);
        accountRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountDTO getById(UUID id) {
        Optional<AccountEntity> optAccount = accountRepository.findById(id);

        // Todo: throw an exception with a descriptive message
        if (optAccount.isEmpty())
            return AccountDTO.builder().build();

        return optAccount.orElseThrow().getDTO();
    }

    @Override
    public AccountDTO depositInAccount(DepositDTO depositDTO) {
        Optional<AccountEntity> optAccount = accountRepository.findByNumberAndCustomerCode(depositDTO.getAccountNumber(), depositDTO.getCustomerCode());
        
        // Todo: throw an exception with a descriptive message
        if (optAccount.isEmpty())
            return AccountDTO.builder().build();

        log.info("New transaction: {}", depositDTO);
        AccountEntity accountEntity = optAccount.orElseThrow();
        accountEntity.setBalance(accountEntity.getBalance().add(depositDTO.getAmount()));

        return accountRepository.save(accountEntity).getDTO();
    }
    
}
