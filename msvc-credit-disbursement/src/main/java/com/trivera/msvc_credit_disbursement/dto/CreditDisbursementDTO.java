package com.trivera.msvc_credit_disbursement.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDisbursementDTO {
    
    private UUID id;
    private BigDecimal amount;
    private Integer termMonths;
    private BigDecimal interestRate;

    private String accountNumber;
    private String customerCode;

}
