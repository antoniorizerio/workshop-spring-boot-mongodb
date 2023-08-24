package com.antoniorizerio.workshopmongo.dto;

import java.io.Serializable;

import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 2930621815646373514L;
	
	private String id;
	private String name;
	
	public AuthorDTO(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.name = userEntity.getName();
	}

}
