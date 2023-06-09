package com.antoniorizerio.workshopmongo.dto;

import java.io.Serializable;
import java.util.Objects;
import com.antoniorizerio.workshopmongo.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 3313438398482226589L;
	
	private String id;
	private String name;
	private String email;
	
	public static UserDTO getUserDTOFromEntity(UserEntity userEntity) {
		if(!Objects.isNull(userEntity)) {
			return new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
		}
		return new UserDTO();
	}
	
	public static UserEntity getUserEntityFromDTO(UserDTO userDTO) {
		if(!Objects.isNull(userDTO)) {
			return new UserEntity(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
		}
		return new UserEntity();
	}
}
