package com.antoniorizerio.workshopmongo.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.antoniorizerio.workshopmongo.repository.UserRepository;
import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;

// Classe de Configuração. O Spring interpreta como uma Configuração //
/**
 * 
 * Essa é uma anotação a nível de Classe que diz para o Container de Inversão de Controle do Spring que essa classe 
 * é a fonte de beans (dependencias requeridas por outras classes no projeto).
 * 
 * A anotação @Bean é usada para indicar que um método de uma classe de configuração retorna um objeto que deve ser 
 * gerenciado pelo contêiner Spring. 
 * 
 * implements CommandLineRunner: Interface used to indicate that a bean should <em>run</em> when it is contained within
 * a {@link SpringApplication}.
 * 
 * @Configuration: Indicates that a class declares one or more {@link Bean @Bean} methods and
 * may be processed by the Spring container to generate bean definitions and
 * service requests for those beans at runtime.
 * 
 * @author kakab
 *
 */
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	// Carga Inicial do Banco de Dados //
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		UserEntity maria = new UserEntity(null, "Maria Brown", "maria@gmail.com");
		UserEntity alex = new UserEntity(null, "Alex Green", "alex@gmail.com");
		UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
}
