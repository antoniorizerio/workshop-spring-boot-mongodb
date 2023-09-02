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
public class ResponseUserFindPosts implements Serializable {
	private static final long serialVersionUID = 3273139955208555399L;
	
	private List<PostDTO> listaPosts = new ArrayList<>();

}
