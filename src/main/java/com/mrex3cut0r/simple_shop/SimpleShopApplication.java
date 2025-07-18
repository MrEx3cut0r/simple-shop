package com.mrex3cut0r.simple_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@AutoConfiguration
@EnableWebMvc
@Controller
public class SimpleShopApplication {

	@GetMapping("/")
	String index() {
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleShopApplication.class, args);
	}

}
