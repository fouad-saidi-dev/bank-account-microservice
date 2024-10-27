package com.fouadev.bankaccountservice.web;

import com.fouadev.bankaccountservice.dto.BankAccountRequestDTO;
import com.fouadev.bankaccountservice.dto.BankAccountResponseDTO;
import com.fouadev.bankaccountservice.entities.BankAccount;
import com.fouadev.bankaccountservice.repositories.BankAccountRepository;
import com.fouadev.bankaccountservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/bankAccounts")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @GetMapping("")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getBankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @PostMapping("")
    public BankAccountResponseDTO createBankAccount(@RequestBody BankAccountRequestDTO bankAccount) {
        return accountService.addBankAccount(bankAccount);
    }

    @PutMapping("/{id}")
    public BankAccount updateBankAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount existingBankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Bank account with id %s not found", id)));

        if (bankAccount.getBalance() != null)
            existingBankAccount.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency() != null)
            existingBankAccount.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType() != null)
            existingBankAccount.setType(bankAccount.getType());
        if (bankAccount.getCreatedAt() != null)
            existingBankAccount.setCreatedAt(bankAccount.getCreatedAt());

        return bankAccountRepository.save(existingBankAccount);
    }
}