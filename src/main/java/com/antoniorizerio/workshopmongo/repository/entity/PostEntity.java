package com.antoniorizerio.workshopmongo.repository.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class PostEntity implements Serializable {
	private static final long serialVersionUID = 5835337734428217423L;
	
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private UserEntity author;
	
}
