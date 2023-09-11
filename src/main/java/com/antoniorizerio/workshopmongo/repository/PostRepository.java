package com.antoniorizerio.workshopmongo.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.antoniorizerio.workshopmongo.repository.entity.PostEntity;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String>{

	/** Criação de uma Query Method, que consulta registros onde o Title contém o texto
	 *  passado como argumento.
	 */
	List<PostEntity> findByTitleContainingIgnoreCase(String text);
	
	// Entrar com a consulta do MongoDB na forma de texto Json //
	// $regex: ?0 -> primeiro parâmetro que vem no método: 'text' //
	// $options: 'i' -> ignora na consulta maisculas e minusculas //
	@Query("{ 'title': {$regex: ?0, $options: 'i' } }")
	List<PostEntity> searchTitle(String text);
	
	@Query("{ $and: [ { 'date': {$gte: ?1} }, { 'date': {$lte: ?2} }, { $or: [ { 'title': {$regex: ?0, $options: 'i' } }, { 'body': {$regex: ?0, $options: 'i' } }, { 'comments.text': {$regex: ?0, $options: 'i' } } ] } ] }")
	List<PostEntity> findByTitleBodyCommentsContainingAndBetweenDates(String text, Date minDate, Date maxDate);
}
