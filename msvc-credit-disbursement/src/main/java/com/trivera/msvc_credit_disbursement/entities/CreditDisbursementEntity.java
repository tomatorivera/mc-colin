package com.trivera.msvc_credit_disbursement.entities;

import java.math.BigDecimal;
import java.util.UUID;

import com.trivera.msvc_credit_disbursement.dto.CreditDisbursementDTO;
import com.trivera.msvc_credit_disbursement.util.IMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "credits")
@Getter
@Setter
@ToString
public class CreditDisbursementEntity implements IMapper<CreditDisbursementDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private Integer termMonths;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal interestRate;

    @Column(nullable = false, length = 60)
    private String accountNumber;

    @Column(nullable = false, length = 20)
    private String customerCode;

    @Override
    public CreditDisbursementDTO getDTO() {
        return CreditDisbursementDTO.builder()
                    .id(id)
                    .amount(amount)
                    .termMonths(termMonths)
                    .interestRate(interestRate)
                    .accountNumber(accountNumber)
                    .customerCode(customerCode)
                    .build();
    }

    @Override
    public void setData(CreditDisbursementDTO t) {
        this.id = t.getId();
        this.amount = t.getAmount();
        this.termMonths = t.getTermMonths();
        this.interestRate = t.getInterestRate();
        this.accountNumber = t.getAccountNumber();
        this.customerCode = t.getCustomerCode();
    }
    
}
