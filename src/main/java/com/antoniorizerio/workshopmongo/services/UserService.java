package com.antoniorizerio.workshopmongo.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoniorizerio.workshopmongo.dto.UserDTO;
import com.antoniorizerio.workshopmongo.entities.UserEntity;
import com.antoniorizerio.workshopmongo.repositories.UserRepository;
import com.antoniorizerio.workshopmongo.response.FindAllUserResponse;

@Service
public class UserService {

	// Mecanismo de Injeção de Dependência do Spring //
	@Autowired 
	private UserRepository userRepository;
	
	public FindAllUserResponse findAll() {
		List<UserEntity> listAllUsers = userRepository.findAll();
		FindAllUserResponse response = new FindAllUserResponse();
		if(!isEmpty(listAllUsers)) {
			UserDTO userDTO = null;
			for(UserEntity entity: listAllUsers) {
				userDTO = UserDTO.getUserDTOFromEntity(entity);
				response.getListUserDTO().add(userDTO);
			}
		}
		return response;
	}
	
	private boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
