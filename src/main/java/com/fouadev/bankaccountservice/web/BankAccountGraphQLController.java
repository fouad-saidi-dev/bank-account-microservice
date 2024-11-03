package com.fouadev.bankaccountservice.web;

import com.fouadev.bankaccountservice.dto.BankAccountRequestDTO;
import com.fouadev.bankaccountservice.dto.BankAccountResponseDTO;
import com.fouadev.bankaccountservice.entities.BankAccount;
import com.fouadev.bankaccountservice.entities.Customer;
import com.fouadev.bankaccountservice.repositories.BankAccountRepository;
import com.fouadev.bankaccountservice.repositories.CustomerRepository;
import com.fouadev.bankaccountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accounts() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO saveBankAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addBankAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateBankAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteBankAccount(@Argument String id) {
        accountService.deleteBankAccount(id);
    }
    @QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }
}

