package com.antoniorizerio.workshopmongo.domain;

import java.io.Serializable;
import java.util.Objects;

import com.antoniorizerio.workshopmongo.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain implements Serializable {

	private static final long serialVersionUID = 3313438398482226738L;
	
	private String id;
	private String name;
	private String email;
	
	public static UserDomain getUserDomain(UserEntity userEntity) {
		if(!Objects.isNull(userEntity)) {
			return new UserDomain(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
		}
		return new UserDomain();
	}
}
