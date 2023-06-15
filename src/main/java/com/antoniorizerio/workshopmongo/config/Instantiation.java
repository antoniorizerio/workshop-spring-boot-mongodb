package com.antoniorizerio.workshopmongo.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.antoniorizerio.workshopmongo.entities.UserEntity;
import com.antoniorizerio.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		UserEntity maria = new UserEntity(null, "Maria Brown", "maria@gmail.com");
		UserEntity alex = new UserEntity(null, "Alex Green", "alex@gmail.com");
		UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
}
