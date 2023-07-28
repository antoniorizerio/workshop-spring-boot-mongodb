package com.antoniorizerio.workshopmongo.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoniorizerio.workshopmongo.repository.UserRepository;
import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;
import com.antoniorizerio.workshopmongo.request.InsertUserRequest;
import com.antoniorizerio.workshopmongo.response.FindAllUserResponse;
import com.antoniorizerio.workshopmongo.response.FindByIdUserResponse;
import com.antoniorizerio.workshopmongo.response.InsertUserResponse;
import com.antoniorizerio.workshopmongo.service.exceptions.ObjectNotFoundException;
import com.antoniorizerio.workshopmongo.util.ConversaoUtil;
import com.antoniorizerio.workshopmongo.util.CreateObjectsUtil;

@Service
public class UserService {

	// Mecanismo de Injeção de Dependência do Spring //
	@Autowired 
	private UserRepository userRepository;
	
	public FindAllUserResponse findAll() {
		List<UserEntity> listAllUsers = userRepository.findAll();
		if(!isEmpty(listAllUsers)) {
		    return CreateObjectsUtil.createFindAllUserResponseWithListDTO(
					listAllUsers.stream().map(userEntity -> 
					 ConversaoUtil.getUserDTOFromEntity(userEntity)).collect(Collectors.toList()));
		}
		return CreateObjectsUtil.createFindAllUserResponseEmpty();
	}
	
	public FindByIdUserResponse findById(String id) {
		FindByIdUserResponse response = CreateObjectsUtil.createFindByIdUserResponseEmpty();
		if(!objectStringIsEmpty(id)) {
			Optional<UserEntity> OptUserEntity = userRepository.findById(id);
			OptUserEntity.ifPresentOrElse(x -> {
				response.setUserDTO(ConversaoUtil.getUserDTOFromEntity(x));	
			}, () -> { throw new ObjectNotFoundException("Objeto com id: "+ id +" não encontrado."); });
		}
		return response;
	}
	
	public InsertUserResponse insert(InsertUserRequest request) {
		InsertUserResponse response = CreateObjectsUtil.createInsertUserResponseEmpty();
		if(!Objects.isNull(request)) {
			response.setUserDTO(
					ConversaoUtil.getUserDTOFromEntity(
					   userRepository.insert(
							ConversaoUtil.getUserEntityFromDTO(request.getUserDTO()))));
		}
		return response;
	}
	
	private boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
	
	private boolean objectStringIsEmpty(String id) {
		if(Objects.isNull(id)) {
			return true;
		}
		if(id.isEmpty()) {
			return true;
		}
		return false;
	}
}
