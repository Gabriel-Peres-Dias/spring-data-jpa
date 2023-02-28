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

    public void inicial(Scanner sc) {
        salvar(sc);
    }

    private void salvar(Scanner sc) {
        System.out.println("Descrição do cargo");
        String descricao = sc.next();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        repository.save(cargo);
        System.out.println("Salvo!");
    }

}
