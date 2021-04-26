package com.example.wssbd.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.wssbd.Domain.Post;
import com.example.wssbd.Domain.User;
import com.example.wssbd.Repository.PostRepository;
import com.example.wssbd.Repository.UserRepository;
import com.example.wssbd.dto.AuthorDTO;
@Configuration
public class Instatiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));

		Post pos1 = new Post(null,sdf.parse("21/03/2018"), "Partiu Viagem","Vou viajar para São Paulo. Abraços!", new AuthorDTO (maria ));
		Post pos2 = new Post(null,sdf.parse("23/03/2018"), "Bom Dia","Acordei feliz hoje!", new AuthorDTO (maria ) );
		postRepository.saveAll(Arrays.asList(pos1,pos2));
	}
	

}
