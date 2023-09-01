package com.antoniorizerio.workshopmongo.response;

import java.io.Serializable;
import com.antoniorizerio.workshopmongo.dto.UserComPostsDTO;
import com.antoniorizerio.workshopmongo.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse implements Serializable {
	
	private static final long serialVersionUID = -7453337769573822789L;
	
	private UserDTO userDTO = new UserDTO();

}
