package com.trivera.msvc_account.services;

import java.util.List;
import java.util.UUID;

import com.trivera.msvc_account.dto.AccountDTO;
import com.trivera.msvc_account.dto.DepositDTO;

public interface IAccountService {
    
    // CRUD methods
    List<AccountDTO> getAll();
    AccountDTO getById(UUID id);
    AccountDTO save(AccountDTO account);
    void delete(UUID id);
    
    // Account operations
    AccountDTO depositInAccount(DepositDTO depositDTO);

}
