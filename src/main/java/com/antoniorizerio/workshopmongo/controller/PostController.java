package com.antoniorizerio.workshopmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.antoniorizerio.workshopmongo.response.ResponsePostFindById;
import com.antoniorizerio.workshopmongo.response.ResponsePostFindByTitle;
import com.antoniorizerio.workshopmongo.service.PostService;
import com.antoniorizerio.workshopmongo.util.ConversaoUtil;

@RestController
@RequestMapping(value="/posts") // nome do recurso //
public class PostController {

	@Autowired
	private PostService postService;
	
	
	// OU: @RequestMapping(value="/{id}", method=RequestMethod.GET) //
	// @PathVariable - valor recebido na URL //
	// EndPoint //
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponsePostFindById> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(postService.findById(id));
	}
	
	// OU: @RequestMapping(value= "/titlesearch", method=RequestMethod.GET) //
	// @PathVariable - valor recebido na URL //
	// EndPoint //
	/**
	 * 
	 * @RequestParam é utilizado para pegar uma parâmetro de query da url, por exemplo:
	 * 		http://localhost:8080/topicos?curso=Java
	 * 
	 * O parâmetro curso é um parâmetro de url e para você recuperá-lo no controller, 
	 * você deve utilizar a anotação @RequestParam.
	 * 
	 * Já a anotação @PathVariable serve para pegar um trecho da url que geralmente é dinâmico. Exemplo:
	 * 		http://localhost:8080/topicos/java
	 * 
	 * Agora como não tem o padrão ?nomeParametro=valorParametro na url, o /java não é mais um 
	 * parâmetro de query, mas sim parte da própria url, e para recuperá-lo devemos utilizar a 
	 * anotação @PathVariable
	 */
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<ResponsePostFindByTitle> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {		
		return ResponseEntity.ok().body(postService.findByTitle(ConversaoUtil.decodeParam(text)));
	}
	
	@GetMapping(value = "/titlesearchQuery")
	public ResponseEntity<ResponsePostFindByTitle> findByTitleQuery(@RequestParam(value="text", defaultValue = "") String text) {		
		return ResponseEntity.ok().body(postService.findByTitleQuery(ConversaoUtil.decodeParam(text)));
	}
}
