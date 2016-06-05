package com.mycompany;

import com.mycompany.domain.Customer;
import com.mycompany.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	CustomerService customerService;


	public static void main(String[] args) {

		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo( ) {
		return (args) -> {
			// save a couple of customers
			customerService.save(new Customer("Jack", "Bauer"));
			customerService.save(new Customer("Chloe", "O'Brian"));
			customerService.save(new Customer("Kim", "Bauer"));
			customerService.save(new Customer("David", "Palmer"));
			customerService.save(new Customer("Michelle", "Dessler"));
		};
	}

}
