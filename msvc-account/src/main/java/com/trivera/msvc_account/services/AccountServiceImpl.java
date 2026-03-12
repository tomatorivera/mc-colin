package com.trivera.msvc_account.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.trivera.msvc_account.dto.AccountDTO;
import com.trivera.msvc_account.entities.AccountEntity;
import com.trivera.msvc_account.repositories.IAccountRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AccountServiceImpl implements IAccountService {

    private final IAccountRepository accountRepository;

    public AccountServiceImpl(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDTO> getAll() {
        return accountRepository.findAll().stream().map(AccountEntity::getDTO).toList();
    }

    @Override
    public AccountDTO save(AccountDTO account) {
        log.info((account.getId() != null) 
            ? "Updating account: " + account 
            : "Creating account: " + account
        );

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setData(account);

        return accountRepository.save(accountEntity).getDTO();
    }

    @Override
    public void delete(UUID id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountDTO getById(UUID id) {
        Optional<AccountEntity> optAccount = accountRepository.findById(id);

        // Todo: throw an exception with a descriptive message
        if (optAccount.isEmpty())
            return AccountDTO.builder().build();

        return optAccount.orElseThrow().getDTO();
    }
    
}
