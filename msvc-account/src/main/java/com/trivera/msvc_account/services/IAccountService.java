package com.trivera.msvc_account.services;

import java.util.List;
import java.util.UUID;

import com.trivera.msvc_account.dto.AccountDTO;

public interface IAccountService {
    
    List<AccountDTO> getAll();
    AccountDTO getById(UUID id);
    AccountDTO save(AccountDTO account);
    void delete(UUID id);

}
