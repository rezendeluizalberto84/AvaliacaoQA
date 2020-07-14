package br.mg.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.mg.cadastro.entities.CadastroInsert;


@Repository
public interface CadastroRepository extends JpaRepository<CadastroInsert, Long> {

	CadastroInsert findBynome(String nome);

}
