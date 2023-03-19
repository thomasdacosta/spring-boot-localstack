package br.com.thomasdacosta.repository;

import br.com.thomasdacosta.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdsRepository extends CrudRepository<Aluno, Integer> {

    List<Aluno> findAlunoByNomeContainingIgnoreCase(String nome);

}
