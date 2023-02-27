package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//anotação que faz o com que o spring percorra nas anotações do projeto
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoRepository repository;

	public SpringDataApplication (CargoRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		criarCargo("DESENVOLVEDOR DE SOFTWARE");
	}

	public void criarCargo(String cargo) {
		Cargo cargoModel = new Cargo();
		cargoModel.setDescricao(cargo);
		repository.save(cargoModel);
	}
}
