package com.antoniorizerio.workshopmongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSemPostsDTO implements Serializable {

	private static final long serialVersionUID = 3313438398482226589L;
	
	private String id;
	private String name;
	private String email;
	

}
