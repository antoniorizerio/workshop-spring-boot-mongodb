package com.antoniorizerio.workshopmongo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.antoniorizerio.workshopmongo.dto.UserSemPostsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindAllUserSemPostsResponse implements Serializable {

	private static final long serialVersionUID = -1187168510304582L;
	
	private List<UserSemPostsDTO> listUserDTO = new ArrayList<>();

}
