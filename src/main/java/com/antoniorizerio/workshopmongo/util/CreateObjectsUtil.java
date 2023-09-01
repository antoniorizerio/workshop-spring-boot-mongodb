package com.antoniorizerio.workshopmongo.util;

import java.util.List;

import com.antoniorizerio.workshopmongo.dto.AuthorDTO;
import com.antoniorizerio.workshopmongo.dto.PostDTO;
import com.antoniorizerio.workshopmongo.dto.UserComPostsDTO;
import com.antoniorizerio.workshopmongo.dto.UserDTO;
import com.antoniorizerio.workshopmongo.dto.UserSemPostsDTO;
import com.antoniorizerio.workshopmongo.repository.entity.PostEntity;
import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;
import com.antoniorizerio.workshopmongo.response.DeleteUserResponse;
import com.antoniorizerio.workshopmongo.response.FindAllUserComPostsResponse;
import com.antoniorizerio.workshopmongo.response.FindAllUserSemPostsResponse;
import com.antoniorizerio.workshopmongo.response.FindByIdUserResponse;
import com.antoniorizerio.workshopmongo.response.FindPostsUserResponse;
import com.antoniorizerio.workshopmongo.response.InsertUserResponse;
import com.antoniorizerio.workshopmongo.response.UpdateUserResponse;

public class CreateObjectsUtil {

	public static FindAllUserComPostsResponse createFindAllUserComPostsResponseEmpty() {
		return new FindAllUserComPostsResponse();
	}
	
	public static FindAllUserSemPostsResponse createFindAllUserSemPostsResponseEmpty() {
		return new FindAllUserSemPostsResponse();
	}
	
	public static FindAllUserComPostsResponse createFindAllUserComPostsResponse(List<UserComPostsDTO> listUserDTO) {
		return new FindAllUserComPostsResponse(listUserDTO);
	}
	
	public static FindAllUserSemPostsResponse createFindAllUserSemPostsResponse(List<UserSemPostsDTO> listUserDTO) {
		return new FindAllUserSemPostsResponse(listUserDTO);
	}
	
	public static FindByIdUserResponse createFindByIdUserResponseEmpty() {
		return new FindByIdUserResponse();
	}
	
	public static FindByIdUserResponse createFindByIdUserResponseWithDTO(UserDTO userDTO) {
		return new FindByIdUserResponse(userDTO);
	}
	
	public static InsertUserResponse createInsertUserResponseEmpty() {
		return new InsertUserResponse();
	}
	
	public static DeleteUserResponse createDeleteUserResponseEmpty() {
		return new DeleteUserResponse();
	}
	
	public static UpdateUserResponse createUpdateUserResponseEmpty() {
		return new UpdateUserResponse();
	}
	
	public static AuthorDTO createAuthorDTOFromUser(UserEntity userEntity) {
		return new AuthorDTO(userEntity);
	}
	
	public static AuthorDTO createAuthorDTO() {
		return new AuthorDTO();
	}
	
	public static FindPostsUserResponse createFindPostsUserResponseEmpty() {
		return new FindPostsUserResponse();
	}
	
	public static PostDTO createPostDTO(PostEntity postEntity) {
		if(postEntity != null) {
			return new PostDTO(postEntity.getId(), postEntity.getDate(), 
					postEntity.getTitle(), postEntity.getBody(), postEntity.getAuthor());
		}
		return new PostDTO();
	}
}
