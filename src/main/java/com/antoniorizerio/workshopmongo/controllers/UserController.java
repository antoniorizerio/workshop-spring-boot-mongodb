package com.antoniorizerio.workshopmongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.antoniorizerio.workshopmongo.response.FindAllUserResponse;
import com.antoniorizerio.workshopmongo.response.FindByIdUserResponse;
import com.antoniorizerio.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// OU: @RequestMapping(method = RequestMethod.GET) //
	@GetMapping
	public ResponseEntity<FindAllUserResponse> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	// OU: @RequestMapping(value="/{id}", method=RequestMethod.GET) //
	// @PathVariable - valor recebido na URL //
	@GetMapping(value = "/{id}")
	public ResponseEntity<FindByIdUserResponse> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}
}
