package com.antoniorizerio.workshopmongo.util;

import java.util.List;
import com.antoniorizerio.workshopmongo.dto.UserDTO;
import com.antoniorizerio.workshopmongo.response.DeleteUserResponse;
import com.antoniorizerio.workshopmongo.response.FindAllUserResponse;
import com.antoniorizerio.workshopmongo.response.FindByIdUserResponse;
import com.antoniorizerio.workshopmongo.response.InsertUserResponse;
import com.antoniorizerio.workshopmongo.response.UpdateUserResponse;

public class CreateObjectsUtil {

	public static FindAllUserResponse createFindAllUserResponseEmpty() {
		return new FindAllUserResponse();
	}
	
	public static FindAllUserResponse createFindAllUserResponseWithListDTO(List<UserDTO> listUserDTO) {
		return new FindAllUserResponse(listUserDTO);
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
}
