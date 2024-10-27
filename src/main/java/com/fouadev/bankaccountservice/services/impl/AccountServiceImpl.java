package com.fouadev.bankaccountservice.services.impl;


import com.fouadev.bankaccountservice.dto.BankAccountRequestDTO;
import com.fouadev.bankaccountservice.dto.BankAccountResponseDTO;
import com.fouadev.bankaccountservice.entities.BankAccount;
import com.fouadev.bankaccountservice.mappers.AccountMapper;
import com.fouadev.bankaccountservice.repositories.BankAccountRepository;
import com.fouadev.bankaccountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO) {

        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .createdAt(new Date())
                .build();

        BankAccount saveAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO responseDTO = accountMapper.fromBankAccount(saveAccount);

        return responseDTO;
    }

}