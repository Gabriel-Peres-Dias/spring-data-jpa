package br.com.alura.spring.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

    //Derived query
    List<Funcionario> findByNome(String nome);


    //jpql
    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome " +
            "AND f.salario >= :salario AND f.dataContratacao = :dataContratacao")
    List<Funcionario> buscarNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate dataContratacao);
}
