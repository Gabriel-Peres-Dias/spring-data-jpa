package br.com.alura.spring.data;

import java.util.Scanner;

import br.com.alura.spring.data.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Boolean system = true;

    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
    private final RelatoriosService relatoriosService;
    private final RelatorioFuncionarioDinamicoService relatorioFuncionarioDinamicoService;

    public SpringDataApplication(
            CrudCargoService cargoService,
            CrudFuncionarioService funcionarioService,
            CrudUnidadeTrabalhoService unidadeTrabalhoService,
            RelatoriosService relatoriosService,
            RelatorioFuncionarioDinamicoService relatorioFuncionarioDinamicoService) {
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeTrabalhoService = unidadeTrabalhoService;
        this.relatoriosService = relatoriosService;
        this.relatorioFuncionarioDinamicoService = relatorioFuncionarioDinamicoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (system) {
            System.out.println("Qual função deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Funcionario");
            System.out.println("3 - Unidade");
            System.out.println("4 - Relatorios");
            System.out.println("5 - Relatorio Dinâmico");

            Integer function = scanner.nextInt();

            switch (function) {
                case 1 -> cargoService.inicial(scanner);
                case 2 -> funcionarioService.inicial(scanner);
                case 3 -> unidadeTrabalhoService.inicial(scanner);
                case 4 -> relatoriosService.inicial(scanner);
                case 5 -> relatorioFuncionarioDinamicoService.inicial(scanner);
                default -> {
                    System.out.println("Finalizando");
                    system = false;
                }
            }
        }
    }
}
