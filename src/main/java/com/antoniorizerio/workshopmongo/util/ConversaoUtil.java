package com.antoniorizerio.workshopmongo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.antoniorizerio.workshopmongo.dto.AuthorDTO;
import com.antoniorizerio.workshopmongo.dto.PostDTO;
import com.antoniorizerio.workshopmongo.dto.UserComPostsDTO;
import com.antoniorizerio.workshopmongo.dto.UserDTO;
import com.antoniorizerio.workshopmongo.dto.UserSemPostsDTO;
import com.antoniorizerio.workshopmongo.repository.entity.PostEntity;
import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;

public class ConversaoUtil {
	
	public static PostDTO getPostDTOFromEntity(PostEntity postEntity) {
		if(!Objects.isNull(postEntity)) {
			return new PostDTO(postEntity.getId(), postEntity.getDate(), 
					postEntity.getTitle(), postEntity.getBody(), postEntity.getAuthor(), 
					postEntity.getComments());
		}
		return new PostDTO();
	}
	
	public static UserComPostsDTO getUserComPostsDTOFromEntity(UserEntity userEntity) {
		if(!Objects.isNull(userEntity)) {
			return new UserComPostsDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(),
					getListaPostDTOFromUser(userEntity.getPosts()));
		}
		return new UserComPostsDTO();
	}
	
	public static UserSemPostsDTO getUserSemPostsDTOFromEntity(UserEntity userEntity) {
		if(!Objects.isNull(userEntity)) {
			return new UserSemPostsDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
		}
		return new UserSemPostsDTO();
	}
	
	public static UserDTO getUserDTOFromEntity(UserEntity userEntity) {
		if(!Objects.isNull(userEntity)) {
			return new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
		}
		return new UserDTO();
	}
	
	public static UserEntity getUserEntityFromDTO(UserComPostsDTO userDTO) {
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
	
	public static List<PostDTO> getListaPostDTOFromUser(List<PostEntity> listaPostEntity) {
		if(!Objects.isNull(listaPostEntity) && !listaPostEntity.isEmpty()) {
			
			return listaPostEntity.stream().map(postEntity -> {
				return CreateObjectsUtil.createPostDTO(postEntity);
			}).toList();
		}
		return new ArrayList<>();
	}
}
