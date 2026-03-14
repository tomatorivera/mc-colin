package com.trivera.msvc_account.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trivera.msvc_account.dto.AccountDTO;
import com.trivera.msvc_account.dto.DepositDTO;
import com.trivera.msvc_account.services.IAccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAll();
    }

    @PostMapping
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) { 
        // Todo: add model validations
        return accountService.save(accountDTO);
    }

    @PutMapping
    public AccountDTO depositAccount(@RequestBody DepositDTO depositDTO) {
        return accountService.depositInAccount(depositDTO);
    }

}
