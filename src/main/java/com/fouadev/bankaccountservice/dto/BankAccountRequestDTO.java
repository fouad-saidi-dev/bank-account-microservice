package com.fouadev.bankaccountservice.dto;

import com.fouadev.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}