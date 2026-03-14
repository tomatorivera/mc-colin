package com.trivera.msvc_credit_disbursement.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trivera.msvc_credit_disbursement.dto.CreditDisbursementDTO;
import com.trivera.msvc_credit_disbursement.services.ICreditDisbursementService;

@RestController
@RequestMapping("/credits")
public class CreditDisbursementController {
    
    private final ICreditDisbursementService creditService;

    public CreditDisbursementController(ICreditDisbursementService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public CreditDisbursementDTO addCredit(@RequestBody CreditDisbursementDTO credit) {
        return creditService.add(credit);
    }

}
