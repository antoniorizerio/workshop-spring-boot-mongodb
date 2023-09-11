package com.antoniorizerio.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSearchTextAndDatesDTO implements Serializable {

	private static final long serialVersionUID = 9059224943929771896L;

	private String text;
	
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT")
	private Date dataMinima;
	
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT")
	private Date dataMaxima;
}
