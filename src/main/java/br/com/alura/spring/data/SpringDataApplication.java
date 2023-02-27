package br.com.alura.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//anotação que faz o com que o spring percorra nas anotações do projeto
@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

}
