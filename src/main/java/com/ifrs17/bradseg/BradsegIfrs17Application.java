package com.ifrs17.bradseg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BradsegIfrs17Application {
	// unica forma de criar o 1o adm é pegar a senha e colocar manualmente no banco de dados
	// tem que criar qualquer usuário e a senha é de seis dígitos encriptada com BCrypt
	public static void main(String[] args) {
		SpringApplication.run(BradsegIfrs17Application.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("victor"));
		System.out.println("aplicação start");
	}

}
