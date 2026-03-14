package com.trivera.msvc_credit_disbursement.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public List<CreditDisbursementDTO> getAll() {
        return creditService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditDisbursementDTO> getById(@PathVariable UUID id) {
        CreditDisbursementDTO credit = creditService.getById(id);

        if (credit.getId() == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(credit);
    }

    @PostMapping
    public CreditDisbursementDTO addCredit(@RequestBody CreditDisbursementDTO credit) {
        return creditService.add(credit);
    }

}
