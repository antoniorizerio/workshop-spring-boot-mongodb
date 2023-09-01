package com.antoniorizerio.workshopmongo.repository.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Serializable: objetos convertidos em bytes, para ser trafegado em rede, gravado em arquivo. //
@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode. //
@NoArgsConstructor // Construtor sem argumentos //
@AllArgsConstructor // Construtor com todos argumentos //
@Document(collection = "user") // Indicar que se trata de uma coleção do MongoDB //
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 5691041082194263154L;
	
	@Id
	private String id;
	private String name;
	private String email;
	
	// A representation of a database reference. //
	@DBRef(lazy = true) // Um atributo está referenciando outra coleção do MongoDB //
	// lazy = true, para só trazer a coleção quando for solicitado, por padrão não traz//
	// Traz as informações do Usuário //
	private List<PostEntity> posts = new ArrayList<>();

	public UserEntity(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
}
