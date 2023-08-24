package com.antoniorizerio.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.antoniorizerio.workshopmongo.repository.PostRepository;
import com.antoniorizerio.workshopmongo.repository.UserRepository;
import com.antoniorizerio.workshopmongo.repository.entity.PostEntity;
import com.antoniorizerio.workshopmongo.repository.entity.UserEntity;
import com.antoniorizerio.workshopmongo.util.ConversaoUtil;

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
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// Carga Inicial do Banco de Dados //
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("teste");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date data1 = sdf.parse("21/03/2018");
		Date data2 = sdf.parse("23/03/2018");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		UserEntity maria = new UserEntity(null, "Maria Brown", "maria@gmail.com");
		UserEntity alex = new UserEntity(null, "Alex Green", "alex@gmail.com");
		UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		PostEntity post1 = new PostEntity(null, data1, "Partiu viagem", "Vou viajar para São Paulo. Abraços", ConversaoUtil.getAuthorDTOFromUser(maria));
		PostEntity post2 = new PostEntity(null, data2, "Bom dia", "Acordei feliz hoje!", ConversaoUtil.getAuthorDTOFromUser(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
