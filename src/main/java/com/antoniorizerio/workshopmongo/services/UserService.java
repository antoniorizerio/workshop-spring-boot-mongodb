package com.antoniorizerio.workshopmongo.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.antoniorizerio.workshopmongo.dto.UserDTO;
import com.antoniorizerio.workshopmongo.entities.UserEntity;
import com.antoniorizerio.workshopmongo.repositories.UserRepository;
import com.antoniorizerio.workshopmongo.response.FindAllUserResponse;
import com.antoniorizerio.workshopmongo.response.FindByIdUserResponse;
import com.antoniorizerio.workshopmongo.services.exceptions.ObjectNotFoundException;

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
	
	public FindByIdUserResponse findById(String id) {
		FindByIdUserResponse response = new FindByIdUserResponse();
		Optional<UserEntity> userEntityOpt = userRepository.findById(id);
		userEntityOpt.ifPresentOrElse(x -> {
			response.setUserDTO(UserDTO.getUserDTOFromEntity(x));
		}, () -> { throw new ObjectNotFoundException("Objeto com id: "+ id +" não encontrado."); });
		return response;
	}
	
	private boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
