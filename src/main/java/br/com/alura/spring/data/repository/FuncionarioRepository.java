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

    //native query, buscas nativas do banco que utilizamos
    @Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
    List<Funcionario> findDataContratacaoMaior(LocalDate data);
}
