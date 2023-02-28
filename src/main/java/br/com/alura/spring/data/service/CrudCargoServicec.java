package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoServicec {

    @Autowired
    private CargoRepository repository;
    private Boolean system = true;

    public void inicial(Scanner sc) {
        while (system) {
            System.out.println("Qual a ação deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int acao = sc.nextInt();

            switch (acao) {
                case 1 -> salvar(sc);
                case 2 -> atualizar(sc);
                case 3 -> visualizar();
                case 4 -> deletar(sc);
                default -> system = false;
            }

        }

    }

    private void salvar(Scanner sc) {
        System.out.println("Descrição do cargo");
        String descricao = sc.next();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        repository.save(cargo);
        System.out.println("Salvo!");
    }

    private void atualizar (Scanner sc) {
        System.out.println("Id do cargo");
        int id = sc.nextInt();
        System.out.println("Nova descrição do cargo");
        String descricao = sc.next();

        Cargo cargo = new Cargo(id,descricao);
        repository.save(cargo);
        System.out.println("Salvo!");

    }

    private void visualizar() {
        Iterable<Cargo> cargos = repository.findAll();
        cargos.forEach(System.out::println);
    }

    private void deletar(Scanner sc) {
        System.out.println("Id do cargo");
        int id = sc.nextInt();
        repository.deleteById(id);
        System.out.println("Registro excluído!");
    }

}
