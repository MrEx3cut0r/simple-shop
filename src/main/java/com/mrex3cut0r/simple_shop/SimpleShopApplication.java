package com.mrex3cut0r.simple_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SimpleShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleShopApplication.class, args);
	}

}
