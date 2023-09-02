package com.antoniorizerio.workshopmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoniorizerio.workshopmongo.repository.PostRepository;
import com.antoniorizerio.workshopmongo.repository.entity.PostEntity;
import com.antoniorizerio.workshopmongo.response.ResponsePostFindById;
import com.antoniorizerio.workshopmongo.service.exceptions.BadRequestException;
import com.antoniorizerio.workshopmongo.service.exceptions.ObjectNotFoundException;
import com.antoniorizerio.workshopmongo.util.ConversaoUtil;
import com.antoniorizerio.workshopmongo.util.CreateObjectsUtil;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public ResponsePostFindById findById(String id) {
		if(id == null) throw new BadRequestException("Identificador do POST está NULLO");
		
		Optional<PostEntity> optPostEntity = postRepository.findById(id);
		ResponsePostFindById response = CreateObjectsUtil.createResponsePostFindByIdEmpty();
		optPostEntity.ifPresentOrElse(postEntity -> {
			
			response.setPostDTO(ConversaoUtil.getPostDTOFromEntity(postEntity));
			
		}, () -> { throw new ObjectNotFoundException("Post com id: "+ id +" não encontrado.");});
		
		return response;
	}

}
