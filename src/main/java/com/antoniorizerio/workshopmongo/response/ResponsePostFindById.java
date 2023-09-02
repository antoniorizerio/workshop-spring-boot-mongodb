package com.antoniorizerio.workshopmongo.response;

import java.io.Serializable;
import com.antoniorizerio.workshopmongo.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePostFindById implements Serializable {
	private static final long serialVersionUID = -865901238913876875L;

	private PostDTO postDTO = new PostDTO();
	
}
