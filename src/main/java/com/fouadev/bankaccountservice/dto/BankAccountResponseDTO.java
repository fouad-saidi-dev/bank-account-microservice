package com.fouadev.bankaccountservice.dto;

import com.fouadev.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Double balance;
    private String currency;
    private AccountType type;
    private Date createdAt;
}