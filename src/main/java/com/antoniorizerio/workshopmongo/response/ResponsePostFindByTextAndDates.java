package com.antoniorizerio.workshopmongo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.antoniorizerio.workshopmongo.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePostFindByTextAndDates implements Serializable {

	private static final long serialVersionUID = -2221018463153922444L;
	
	private List<PostDTO> listaPostDTO = new ArrayList<>();
	
}
