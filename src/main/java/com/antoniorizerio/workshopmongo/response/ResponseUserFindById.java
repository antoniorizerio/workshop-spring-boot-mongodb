package com.antoniorizerio.workshopmongo.response;

import java.io.Serializable;

import com.antoniorizerio.workshopmongo.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserFindById implements Serializable {

	private static final long serialVersionUID = -200041577253755583L;
	
	private UserDTO userDTO = new UserDTO();
}
