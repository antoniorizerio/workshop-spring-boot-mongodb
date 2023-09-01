package com.antoniorizerio.workshopmongo.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoniorizerio.workshopmongo.dto.UserComPostsDTO;
import com.antoniorizerio.workshopmongo.repository.UserRepository;
import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;
import com.antoniorizerio.workshopmongo.request.InsertUserRequest;
import com.antoniorizerio.workshopmongo.request.UpdateUserRequest;
import com.antoniorizerio.workshopmongo.response.DeleteUserResponse;
import com.antoniorizerio.workshopmongo.response.FindAllUserComPostsResponse;
import com.antoniorizerio.workshopmongo.response.FindAllUserSemPostsResponse;
import com.antoniorizerio.workshopmongo.response.FindByIdUserResponse;
import com.antoniorizerio.workshopmongo.response.FindPostsUserResponse;
import com.antoniorizerio.workshopmongo.response.InsertUserResponse;
import com.antoniorizerio.workshopmongo.response.UpdateUserResponse;
import com.antoniorizerio.workshopmongo.service.exceptions.ObjectNotFoundException;
import com.antoniorizerio.workshopmongo.util.ConversaoUtil;
import com.antoniorizerio.workshopmongo.util.CreateObjectsUtil;

@Service
public class UserService {

	// Mecanismo de Injeção de Dependência do Spring //
	@Autowired 
	private UserRepository userRepository;
	
	public FindAllUserComPostsResponse findAllWithPosts() {
		List<UserEntity> listAllUsers = userRepository.findAll();
		if(!isEmpty(listAllUsers)) {
		    return CreateObjectsUtil.createFindAllUserComPostsResponse(
					listAllUsers.stream().map(userEntity -> 
					 ConversaoUtil.getUserComPostsDTOFromEntity(userEntity)).collect(Collectors.toList()));
		}
		return CreateObjectsUtil.createFindAllUserComPostsResponseEmpty();
	}
	
	public FindAllUserSemPostsResponse findAllWithoutPosts() {
		List<UserEntity> listAllUsers = userRepository.findAll();
		if(!isEmpty(listAllUsers)) {
		    return CreateObjectsUtil.createFindAllUserSemPostsResponse(
					listAllUsers.stream().map(userEntity -> 
					 ConversaoUtil.getUserSemPostsDTOFromEntity(userEntity)).collect(Collectors.toList()));
		}
		return CreateObjectsUtil.createFindAllUserSemPostsResponseEmpty();
	}
	
	public FindByIdUserResponse findById(String id) {
		FindByIdUserResponse response = CreateObjectsUtil.createFindByIdUserResponseEmpty();
		Optional<UserEntity> OptUserEntity = userRepository.findById(id);
			OptUserEntity.ifPresentOrElse(x -> {
				response.setUserDTO(ConversaoUtil.getUserDTOFromEntity(x));	
		}, () -> { throw new ObjectNotFoundException("Objeto com id: "+ id +" não encontrado."); });
		return response;
	}
	
	public FindPostsUserResponse findPosts(String id) {
		FindPostsUserResponse response = CreateObjectsUtil.createFindPostsUserResponseEmpty();
		Optional<UserEntity> OptUserEntity = userRepository.findById(id);
		OptUserEntity.ifPresentOrElse(userEntity -> {
			response.setListaPosts(ConversaoUtil.
					getListaPostDTOFromUser(userEntity.getPosts()));
		}, () -> { throw new ObjectNotFoundException("Objeto com id: "+ id +" não encontrado."); });
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
	
	public DeleteUserResponse delete(String id) {
		DeleteUserResponse response = CreateObjectsUtil.createDeleteUserResponseEmpty();
		Optional<UserEntity> optUserEntity = userRepository.findById(id);
		optUserEntity.ifPresentOrElse(userEntity -> {
			response.setUserDTO(ConversaoUtil.getUserDTOFromEntity(userEntity));
			userRepository.delete(userEntity);
		},() -> { throw new ObjectNotFoundException("Objeto com id: "+ id +" não encontrado."); });
		return response;
	}
	
	public UpdateUserResponse update(UpdateUserRequest updateUserRequest) {
		UpdateUserResponse response = CreateObjectsUtil.createUpdateUserResponseEmpty();
		if(!isUpdateUserDTOEmpty(updateUserRequest)) {
			Optional<UserEntity> optUserEntity = userRepository.findById(updateUserRequest.getUserDTO().getId());
			optUserEntity.ifPresentOrElse(userEntity -> {
				configUpdateUserEntity(userEntity, updateUserRequest.getUserDTO());
				response.setUserDTO(ConversaoUtil.getUserDTOFromEntity(userRepository.save(userEntity)));
			},() -> { throw new ObjectNotFoundException("Objeto com id: "+ updateUserRequest.getUserDTO().getId() 
							+" não encontrado."); });
		}
		return response;
	}
	
	private void configUpdateUserEntity(UserEntity userEntity, UserComPostsDTO userDTO) {
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setName(userDTO.getName());
	}
	
	private boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
	
	private boolean isUpdateUserDTOEmpty(UpdateUserRequest updateUserRequest) {
		if(!Objects.isNull(updateUserRequest) && !Objects.isNull(updateUserRequest.getUserDTO())) {
			return false;
		}
		return true;
	}
}
