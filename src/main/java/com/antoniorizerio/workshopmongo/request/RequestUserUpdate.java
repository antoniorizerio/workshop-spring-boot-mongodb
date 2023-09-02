package com.antoniorizerio.workshopmongo.request;

import java.io.Serializable;
import com.antoniorizerio.workshopmongo.dto.UserComPostsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserUpdate implements Serializable {

	private static final long serialVersionUID = -8156094466792614100L;
	
	private UserComPostsDTO userDTO = new UserComPostsDTO();

}
