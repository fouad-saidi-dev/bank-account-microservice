package com.fouadev.bankaccountservice;

import com.fouadev.bankaccountservice.entities.BankAccount;
import com.fouadev.bankaccountservice.enums.AccountType;
import com.fouadev.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
    @Bean
	CommandLineRunner run(BankAccountRepository bankAccountRepository) {
		return args -> {

			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.balance(Math.random()*10000)
						.currency("MAD")
						.type(Math.random()>0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.createdAt(new Date())
						.build();

				bankAccountRepository.save(bankAccount);
			}

		};
	}
}
