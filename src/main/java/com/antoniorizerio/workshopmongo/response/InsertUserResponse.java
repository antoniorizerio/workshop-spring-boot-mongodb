package com.antoniorizerio.workshopmongo.response;

import java.io.Serializable;
import com.antoniorizerio.workshopmongo.dto.UserComPostsDTO;
import com.antoniorizerio.workshopmongo.dto.UserDTO;
import com.antoniorizerio.workshopmongo.request.InsertUserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertUserResponse implements Serializable {

	private static final long serialVersionUID = -3323267749717344963L;

	private UserDTO userDTO = new UserDTO();
}
