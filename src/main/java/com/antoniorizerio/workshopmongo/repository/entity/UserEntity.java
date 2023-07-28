package com.antoniorizerio.workshopmongo.repository.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
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
}
