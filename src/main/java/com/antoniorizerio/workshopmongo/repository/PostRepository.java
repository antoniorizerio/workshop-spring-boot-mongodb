package com.antoniorizerio.workshopmongo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.antoniorizerio.workshopmongo.repository.entity.PostEntity;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String>{

	/** Criação de uma Query Method, que consulta registros onde o Title contém o texto
	 *  passado como argumento.
	 */
	List<PostEntity> findByTitleContainingIgnoreCase(String text);
}
