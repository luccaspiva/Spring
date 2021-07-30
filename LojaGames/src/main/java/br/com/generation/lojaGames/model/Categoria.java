package br.com.generation.lojaGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Define que a classe se trata de uma Model/Entity, onde serão passados os atributos da tabela
@Table(name = "tb_categoria") //Define um nome da tabela
public class Categoria {

	@Id //Define a PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY -> Numeração sequencial (1,2,3...)
	private long id;
	
	@NotNull(message = "O atributo Tipo não pode ser nulo!") //Define que o campo deve ser preenchido pelo usuário e não pode ficar nulo
	private String tipo;
	
	//Criando relacionamento
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties
	private List<Produto> produto;

	//Gerando GETTERS e SETTERS:
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
