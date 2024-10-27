package com.fouadev.bankaccountservice.repositories;

import com.fouadev.bankaccountservice.entities.BankAccount;
import com.fouadev.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource //path = "bankAccounts" no need to create a rest controller
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/type")
    List<BankAccount> findByType(@Param("t") AccountType type); // search/findByType?type=CURRENT_ACCOUNT
}
