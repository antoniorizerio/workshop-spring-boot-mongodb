package com.antoniorizerio.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1363691797770432993L;

	private String text;
	private Date date;
	private AuthorDTO author;
}
