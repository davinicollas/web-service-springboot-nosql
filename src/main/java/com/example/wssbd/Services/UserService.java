package com.example.wssbd.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wssbd.Domain.User;
import com.example.wssbd.Repository.UserRepository;
import com.example.wssbd.Services.Exception.ObjectNotFound;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado"));
		
	}
}
