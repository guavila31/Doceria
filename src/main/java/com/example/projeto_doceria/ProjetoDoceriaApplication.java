package com.example.projeto_doceria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProjetoDoceriaApplication {

	@GetMapping("/api")
	public String olaMundo() {
		return "Olá, você esta conectado na API Doceria AC2";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDoceriaApplication.class, args);
	}

}
