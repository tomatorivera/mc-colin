package com.trivera.msvc_credit_disbursement.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trivera.msvc_credit_disbursement.dto.AccountDTO;
import com.trivera.msvc_credit_disbursement.dto.DepositDTO;

@FeignClient(name = "${feign.clients.account.name}", url = "${feign.clients.account.url}")
public interface IAccountRESTClient {
    
    @PutMapping
    ResponseEntity<AccountDTO> depositAccount(@RequestBody DepositDTO deposit);

}
