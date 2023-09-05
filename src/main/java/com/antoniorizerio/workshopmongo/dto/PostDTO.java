package com.antoniorizerio.workshopmongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {
	private static final long serialVersionUID = -1176720327096635454L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();
}
