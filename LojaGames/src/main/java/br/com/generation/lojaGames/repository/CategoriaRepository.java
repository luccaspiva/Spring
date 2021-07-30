package br.com.generation.lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.lojaGames.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
/* 	CategoriaRepository herda de JpaRepository -> fornecida pela dependência JPA
	Essa interface herdada, possui 2 parâmetros, que foram passados -> Categoria e Long
	Categoria se refere a classe Categoria criada anteriormente
	Long se refere ao tipo de dado que se trata o Id -> definido na classe Categoria */
	
	
	public List<Categoria> findAllByTipoContainingIgnoreCase(String tipo);

}
