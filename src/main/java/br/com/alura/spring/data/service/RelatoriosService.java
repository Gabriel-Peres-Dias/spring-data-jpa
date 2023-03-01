package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final FuncionarioRepository repository;

    public RelatoriosService (FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual acao de relatorio deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionarios por nome");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscarPorNome(scanner);
                    break;
                default:
                    system = false;
                    break;
            }

        }
    }

    private void buscarPorNome(Scanner scanner) {
        System.out.println("Qual o nome que deseja buscar?");
        String nome = scanner.next();

        List<Funcionario> funcionarios = repository.findByNome(nome);
        funcionarios.forEach(System.out::println);
    }
}
