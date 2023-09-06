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
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<ResponsePostFindByTitle> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {		
		return ResponseEntity.ok().body(postService.findByTitle(ConversaoUtil.decodeParam(text)));
	}
}
