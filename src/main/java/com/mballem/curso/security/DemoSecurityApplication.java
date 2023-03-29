package com.mballem.curso.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication {

	
	//antes de startar aqui 
	//faz upgrade do projeto
	
	public static void main(String[] args) {
		// unica forma de criar o 1o adm é pegar a senha e colocar manualmente no banco de dados
		// tem que criar qualquer usuário e a senha é de seis dígitos encriptada com BCrypt
		//System.out.println(new BCryptPasswordEncoder().encode("123456"));
		SpringApplication.run(DemoSecurityApplication.class, args);
	}
}
