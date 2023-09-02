package com.antoniorizerio.workshopmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.antoniorizerio.workshopmongo.response.ResponsePostFindById;
import com.antoniorizerio.workshopmongo.service.PostService;

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
}
