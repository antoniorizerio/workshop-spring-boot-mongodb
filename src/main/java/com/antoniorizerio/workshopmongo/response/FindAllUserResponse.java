package com.antoniorizerio.workshopmongo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.antoniorizerio.workshopmongo.domain.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindAllUserResponse implements Serializable {

	private static final long serialVersionUID = -1187168510307017L;
	
	private List<UserDomain> userDomain = new ArrayList<>();

}
