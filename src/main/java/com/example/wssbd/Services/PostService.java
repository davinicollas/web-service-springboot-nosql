package com.example.wssbd.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wssbd.Domain.Post;
import com.example.wssbd.Repository.PostRepository;
import com.example.wssbd.Services.Exception.ObjectNotFound;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado"));
		
	}

}
