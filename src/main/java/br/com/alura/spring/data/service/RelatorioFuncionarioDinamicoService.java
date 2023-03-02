package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Scanner;

public class RelatorioFuncionarioDinamicoService {

    private final FuncionarioRepository repository;

    public RelatorioFuncionarioDinamicoService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        System.out.println("Digite um nome");
        String nome = scanner.next();

        List<Funcionario> funcionarios = repository.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
    }
}
