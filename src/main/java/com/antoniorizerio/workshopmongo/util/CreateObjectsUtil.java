package com.antoniorizerio.workshopmongo.util;

import java.util.List;

import com.antoniorizerio.workshopmongo.dto.AuthorDTO;
import com.antoniorizerio.workshopmongo.dto.PostDTO;
import com.antoniorizerio.workshopmongo.dto.UserComPostsDTO;
import com.antoniorizerio.workshopmongo.dto.UserDTO;
import com.antoniorizerio.workshopmongo.dto.UserSemPostsDTO;
import com.antoniorizerio.workshopmongo.repository.entity.PostEntity;
import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;
import com.antoniorizerio.workshopmongo.response.ResponsePostFindById;
import com.antoniorizerio.workshopmongo.response.ResponsePostFindByTextAndDates;
import com.antoniorizerio.workshopmongo.response.ResponsePostFindByTitle;
import com.antoniorizerio.workshopmongo.response.ResponseUserDelete;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindAllComPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindAllSemPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindById;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserInsert;
import com.antoniorizerio.workshopmongo.response.ResponseUserUpdate;

public class CreateObjectsUtil {

	public static ResponsePostFindByTextAndDates createResponsePostFindByTextAndDatesEmpty() {
		return new ResponsePostFindByTextAndDates();
	}
	
	public static ResponsePostFindByTitle createResponsePostFindByTitleEmpty() {
		return new ResponsePostFindByTitle();
	}
	
	public static ResponsePostFindById createResponsePostFindByIdEmpty() {
		return new ResponsePostFindById();
	}
	
	public static ResponsePostFindById createResponsePostFindById(PostEntity postEntity) {
		return new ResponsePostFindById(ConversaoUtil.getPostDTOFromEntity(postEntity));
	}
	
	public static ResponseUserFindAllComPosts createFindAllUserComPostsResponseEmpty() {
		return new ResponseUserFindAllComPosts();
	}
	
	public static ResponseUserFindAllSemPosts createFindAllUserSemPostsResponseEmpty() {
		return new ResponseUserFindAllSemPosts();
	}
	
	public static ResponseUserFindAllComPosts createFindAllUserComPostsResponse(List<UserComPostsDTO> listUserDTO) {
		return new ResponseUserFindAllComPosts(listUserDTO);
	}
	
	public static ResponseUserFindAllSemPosts createFindAllUserSemPostsResponse(List<UserSemPostsDTO> listUserDTO) {
		return new ResponseUserFindAllSemPosts(listUserDTO);
	}
	
	public static ResponseUserFindById createFindByIdUserResponseEmpty() {
		return new ResponseUserFindById();
	}
	
	public static ResponseUserFindById createFindByIdUserResponseWithDTO(UserDTO userDTO) {
		return new ResponseUserFindById(userDTO);
	}
	
	public static ResponseUserInsert createInsertUserResponseEmpty() {
		return new ResponseUserInsert();
	}
	
	public static ResponseUserDelete createDeleteUserResponseEmpty() {
		return new ResponseUserDelete();
	}
	
	public static ResponseUserUpdate createUpdateUserResponseEmpty() {
		return new ResponseUserUpdate();
	}
	
	public static AuthorDTO createAuthorDTOFromUser(UserEntity userEntity) {
		return new AuthorDTO(userEntity);
	}
	
	public static AuthorDTO createAuthorDTO() {
		return new AuthorDTO();
	}
	
	public static ResponseUserFindPosts createFindPostsUserResponseEmpty() {
		return new ResponseUserFindPosts();
	}
	
	public static PostDTO createPostDTO(PostEntity postEntity) {
		if(postEntity != null) {
			return new PostDTO(postEntity.getId(), postEntity.getDate(), 
					postEntity.getTitle(), postEntity.getBody(), postEntity.getAuthor(),
					postEntity.getComments());
		}
		return new PostDTO();
	}
}
