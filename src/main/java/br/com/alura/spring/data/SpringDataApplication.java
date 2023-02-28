package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoServicec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

//anotação que faz o com que o spring percorra nas anotações do projeto
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	private CrudCargoServicec service;

	private boolean system = true;


	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while(system) {
			System.out.println("Qual a ação executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");

			int action = sc.nextInt();
			if (action == 1) service.inicial(sc);
			system = false;
		}
	}


}
