package com.antoniorizerio.workshopmongo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antoniorizerio.workshopmongo.request.RequestUserInsert;
import com.antoniorizerio.workshopmongo.request.RequestUserUpdate;
import com.antoniorizerio.workshopmongo.response.ResponseUserDelete;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindAllComPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindAllSemPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindById;
import com.antoniorizerio.workshopmongo.response.ResponseUserFindPosts;
import com.antoniorizerio.workshopmongo.response.ResponseUserInsert;
import com.antoniorizerio.workshopmongo.response.ResponseUserUpdate;
import com.antoniorizerio.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users") // nome do recurso //
public class UserController {

	@Autowired
	private UserService userService;
	
	// OU: @RequestMapping(method = RequestMethod.GET) //
	// EndPoint //
	@GetMapping(value = "/posts")
	public ResponseEntity<ResponseUserFindAllComPosts> findAllWithPosts() {
		return ResponseEntity.ok().body(userService.findAllWithPosts());
	}
	
	// OU: @RequestMapping(method = RequestMethod.GET) //
	// EndPoint //
	@GetMapping
	public ResponseEntity<ResponseUserFindAllSemPosts> findAllSemPosts() {
		return ResponseEntity.ok().body(userService.findAllWithoutPosts());
	}
	
	// OU: @RequestMapping(value="/{id}", method=RequestMethod.GET) //
	// @PathVariable - valor recebido na URL //
	// EndPoint //
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseUserFindById> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}

	// OU: @RequestMapping(method=RequestMethod.POST) //
	// EndPoint //
	// Quando inserimos um recurso utilizamos o método POST //
	@PostMapping
	public ResponseEntity<ResponseUserInsert> insert(@RequestBody RequestUserInsert request) {
		ResponseUserInsert response = userService.insert(request);
		
		// ServletUriComponentsBuilder: UriComponentsBuilder with additional static factory methods to create links
		// based on the current HttpServletRequest.
		// fromCurrentRequest() : Recupero a requisição atual, corrente.
		// path("/{id}"): Coloco nela um {id}
		// buildAndExpand: Build a {@code UriComponents} instance and replaces URI template variables
		// with the values from an array.
		// (toUri()): Represents a Uniform Resource Identifier (URI) reference. 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(response.getUserDTO().getId()).toUri();
		return ResponseEntity.created(uri).body(response);
	} 
	
	
	// OU: @RequestMapping(method = RequestMethod.DELETE) //
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseUserDelete> delete(@PathVariable String id) {
		return ResponseEntity.ok(userService.delete(id));
		
		// Para não retornar nada utilizo o comando: 204 //
		//return ResponseEntity.noContent().build();
	}
	
	// OU: @RequestMapping(method = RequestMethod.PUT) //
	@PutMapping
	public ResponseEntity<ResponseUserUpdate> update(@RequestBody RequestUserUpdate request) {
		ResponseUserUpdate response = userService.update(request);
		return ResponseEntity.ok(response);
	}
	
//  OU	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<InsertUserResponse> update(@RequestBody UpdateUserRequest request, @PathVariable String id) {
//		UpdateUserResponse response = userService.update(request);
//		return ResponseEntity.noContent().build();
//	} 
	
	// OU: @RequestMapping(value="/{id}/posts", method=RequestMethod.GET) //
	// @PathVariable - valor recebido na URL //
	// EndPoint //
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<ResponseUserFindPosts> findPosts(@PathVariable String id) {
		return ResponseEntity.ok().body(userService.findPosts(id));
	}
	
}
