package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class PetitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetitionApplication.class, args);
	}

	@GetMapping("/")
	public String redirectToPetitions() {
		return "redirect:/petitions";
	}
}
