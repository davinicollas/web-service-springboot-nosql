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
import com.example.wssbd.dto.ComentDTO;
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
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));

		Post pos1 = new Post(null,sdf.parse("21/03/2018"), "Partiu Viagem","Vou viajar para São Paulo. Abraços!", new AuthorDTO (maria ));
		Post pos2 = new Post(null,sdf.parse("23/03/2018"), "Bom Dia","Acordei feliz hoje!", new AuthorDTO (maria ) );
		
		ComentDTO c1 =  new ComentDTO("BOa Viagem mano !", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		ComentDTO c2 =  new ComentDTO("Aproveite !", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		ComentDTO c3 =  new ComentDTO("tenha um otimo dia !", sdf.parse("23/03/2018"), new AuthorDTO(alex));

		pos1.getComment().addAll(Arrays.asList(c1));
		pos1.getComment().addAll(Arrays.asList(c2));
		pos2.getComment().addAll(Arrays.asList(c3));
		postRepository.saveAll(Arrays.asList(pos1,pos2));
		
		
		
		
		maria.getPost().addAll(Arrays.asList(pos1,pos2));
		userRepository.save(maria);
	}
	

}
