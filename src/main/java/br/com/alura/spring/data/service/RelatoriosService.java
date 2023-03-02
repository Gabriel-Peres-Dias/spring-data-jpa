package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository repository;

    public RelatoriosService (FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual acao de relatorio deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionarios por nome");
            System.out.println("2 - Buscar funcionarios por nome, salario maior e data de contratação");
            System.out.println("3 - Buscar funcionarios por data de contratação maior que");
            System.out.println("4 - Buscar id, nome e salario dos funcionarios");

            int action = scanner.nextInt();

            switch (action) {
                case 1 -> buscarPorNome(scanner);
                case 2 -> buscaFuncionarioNomeSalarioMaiorData(scanner);
                case 3 -> buscarFuncionarioDataContratacaoMaior(scanner);
                case 4 -> buscarIdNomeSalario();
                default -> system = false;
            }

        }
    }

    private void buscarPorNome(Scanner scanner) {
        System.out.println("Qual o nome que deseja buscar?");
        String nome = scanner.next();

        List<Funcionario> funcionarios = repository.findByNome(nome);
        funcionarios.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Qual o nome  deseja buscar?");
        String nome = scanner.next();

        System.out.println("Qual o salário deseja buscar?");
        Double salario = scanner.nextDouble();

        System.out.println("Qual a data da contratação  deseja buscar?");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> funcionarios = repository.buscarNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        funcionarios.forEach(System.out::println);
    }

    private void buscarFuncionarioDataContratacaoMaior(Scanner scanner){
        System.out.println("Qual a data da contratação maior deseja buscar?");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> funcionarios = repository.findDataContratacaoMaior(localDate);
        funcionarios.forEach(System.out::println);
    }

    private void buscarIdNomeSalario() {
        List<FuncionarioProjecao> funcionarios = repository.findFuncionarioSalario();
        funcionarios.forEach(f -> System.out.println("ID: " + f.getId() + " NOME: " + f.getNome() + " SALARIO: " + f.getSalario()));
    }
}
