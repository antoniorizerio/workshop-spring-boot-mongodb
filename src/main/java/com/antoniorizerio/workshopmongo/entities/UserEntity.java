package com.antoniorizerio.workshopmongo.entities;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 5691041082194263154L;
	
	@Id
	private String id;
	private String name;
	private String email;
}
