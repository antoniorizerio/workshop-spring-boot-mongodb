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
import com.antoniorizerio.workshopmongo.request.RequestUserInsert;
import com.antoniorizerio.workshopmongo.request.RequestUserUpdate;
import com.antoniorizerio.workshopmongo.response.ResponseUserDelete;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindAllComPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindAllSemPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindById;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserInsert;
import com.antoniorizerio.workshopmongo.response.ResponseUserUpdate;
import com.antoniorizerio.workshopmongo.service.exceptions.ObjectNotFoundException;
import com.antoniorizerio.workshopmongo.util.ConversaoUtil;
import com.antoniorizerio.workshopmongo.util.CreateObjectsUtil;

@Service
public class UserService {

	// Mecanismo de Injeção de Dependência do Spring //
	@Autowired 
	private UserRepository userRepository;
	
	public ResponseUserFindAllComPosts findAllWithPosts() {
		List<UserEntity> listAllUsers = userRepository.findAll();
		if(!isEmpty(listAllUsers)) {
		    return CreateObjectsUtil.createFindAllUserComPostsResponse(
					listAllUsers.stream().map(userEntity -> 
					 ConversaoUtil.getUserComPostsDTOFromEntity(userEntity)).collect(Collectors.toList()));
		}
		return CreateObjectsUtil.createFindAllUserComPostsResponseEmpty();
	}
	
	public ResponseUserFindAllSemPosts findAllWithoutPosts() {
		List<UserEntity> listAllUsers = userRepository.findAll();
		if(!isEmpty(listAllUsers)) {
		    return CreateObjectsUtil.createFindAllUserSemPostsResponse(
					listAllUsers.stream().map(userEntity -> 
					 ConversaoUtil.getUserSemPostsDTOFromEntity(userEntity)).collect(Collectors.toList()));
		}
		return CreateObjectsUtil.createFindAllUserSemPostsResponseEmpty();
	}
	
	public ResponseUserFindById findById(String id) {
		ResponseUserFindById response = CreateObjectsUtil.createFindByIdUserResponseEmpty();
		Optional<UserEntity> OptUserEntity = userRepository.findById(id);
			OptUserEntity.ifPresentOrElse(x -> {
				response.setUserDTO(ConversaoUtil.getUserDTOFromEntity(x));	
		}, () -> { throw new ObjectNotFoundException("Objeto com id: "+ id +" não encontrado."); });
		return response;
	}
	
	public ResponseUserFindPosts findPosts(String id) {
		ResponseUserFindPosts response = CreateObjectsUtil.createFindPostsUserResponseEmpty();
		Optional<UserEntity> OptUserEntity = userRepository.findById(id);
		OptUserEntity.ifPresentOrElse(userEntity -> {
			response.setListaPosts(ConversaoUtil.
					getListaPostDTOFromUser(userEntity.getPosts()));
		}, () -> { throw new ObjectNotFoundException("Objeto com id: "+ id +" não encontrado."); });
		return response;
	}
	
	public ResponseUserInsert insert(RequestUserInsert request) {
		ResponseUserInsert response = CreateObjectsUtil.createInsertUserResponseEmpty();
		if(!Objects.isNull(request)) {
			response.setUserDTO(
					ConversaoUtil.getUserDTOFromEntity(
					   userRepository.insert(
							ConversaoUtil.getUserEntityFromDTO(request.getUserDTO()))));
		}
		return response;
	}
	
	public ResponseUserDelete delete(String id) {
		ResponseUserDelete response = CreateObjectsUtil.createDeleteUserResponseEmpty();
		Optional<UserEntity> optUserEntity = userRepository.findById(id);
		optUserEntity.ifPresentOrElse(userEntity -> {
			response.setUserDTO(ConversaoUtil.getUserDTOFromEntity(userEntity));
			userRepository.delete(userEntity);
		},() -> { throw new ObjectNotFoundException("Objeto com id: "+ id +" não encontrado."); });
		return response;
	}
	
	public ResponseUserUpdate update(RequestUserUpdate updateUserRequest) {
		ResponseUserUpdate response = CreateObjectsUtil.createUpdateUserResponseEmpty();
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
	
	private boolean isUpdateUserDTOEmpty(RequestUserUpdate updateUserRequest) {
		if(!Objects.isNull(updateUserRequest) && !Objects.isNull(updateUserRequest.getUserDTO())) {
			return false;
		}
		return true;
	}
}
