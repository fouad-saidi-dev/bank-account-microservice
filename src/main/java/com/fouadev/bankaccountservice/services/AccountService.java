package com.fouadev.bankaccountservice.services;

import com.fouadev.bankaccountservice.dto.BankAccountRequestDTO;
import com.fouadev.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO);
}
