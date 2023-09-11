package com.antoniorizerio.workshopmongo.request;

import java.io.Serializable;
import com.antoniorizerio.workshopmongo.dto.PostSearchTextAndDatesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPostFindByTextAndDates implements Serializable {

	private static final long serialVersionUID = 1836193133340268613L;
	
	private PostSearchTextAndDatesDTO postSearch = new PostSearchTextAndDatesDTO();

}
