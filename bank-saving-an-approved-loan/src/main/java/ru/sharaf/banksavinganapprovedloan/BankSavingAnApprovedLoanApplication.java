package ru.sharaf.banksavinganapprovedloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yaml")
public class BankSavingAnApprovedLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSavingAnApprovedLoanApplication.class, args);
	}

}
