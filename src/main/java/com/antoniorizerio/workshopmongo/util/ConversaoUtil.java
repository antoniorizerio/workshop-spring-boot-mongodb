package com.antoniorizerio.workshopmongo.util;

import java.util.Objects;

import com.antoniorizerio.workshopmongo.dto.AuthorDTO;
import com.antoniorizerio.workshopmongo.dto.UserDTO;
import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;

public class ConversaoUtil {
	
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
	
	public static AuthorDTO getAuthorDTOFromUser(UserEntity userEntity) {
		if(!Objects.isNull(userEntity)) {
			return CreateObjectsUtil.createAuthorDTOFromUser(userEntity);
		}
		return CreateObjectsUtil.createAuthorDTO();
	}
}
