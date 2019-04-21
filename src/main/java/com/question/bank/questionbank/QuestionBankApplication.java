package com.question.bank.questionbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuestionBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionBankApplication.class, args);
	}

}
