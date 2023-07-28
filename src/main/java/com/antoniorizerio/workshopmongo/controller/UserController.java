package com.antoniorizerio.workshopmongo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antoniorizerio.workshopmongo.request.InsertUserRequest;
import com.antoniorizerio.workshopmongo.response.FindAllUserResponse;
import com.antoniorizerio.workshopmongo.response.FindByIdUserResponse;
import com.antoniorizerio.workshopmongo.response.InsertUserResponse;
import com.antoniorizerio.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users") // nome do recurso //
public class UserController {

	@Autowired
	private UserService userService;
	
	// OU: @RequestMapping(method = RequestMethod.GET) //
	// EndPoint //
	@GetMapping
	public ResponseEntity<FindAllUserResponse> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	// OU: @RequestMapping(value="/{id}", method=RequestMethod.GET) //
	// @PathVariable - valor recebido na URL //
	// EndPoint //
	@GetMapping(value = "/{id}")
	public ResponseEntity<FindByIdUserResponse> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}

	// OU: @RequestMapping(method=RequestMethod.POST) //
	// EndPoint //
	// Quando inserimos um recurso utilizamos o método POST //
	@PostMapping
	public ResponseEntity<InsertUserResponse> insert(@RequestBody InsertUserRequest request) {
		InsertUserResponse response = userService.insert(request);
		
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
}
