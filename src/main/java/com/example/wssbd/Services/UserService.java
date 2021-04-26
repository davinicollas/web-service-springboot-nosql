package com.example.wssbd.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wssbd.Domain.User;
import com.example.wssbd.Repository.UserRepository;
import com.example.wssbd.Services.Exception.ObjectNotFound;
import com.example.wssbd.dto.UserDTO;

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
	public User insert(User obj) {
		return repo.insert(obj);
	}
	public User fromDTO(UserDTO objDTO)
	{
		return new User(objDTO.getId(),objDTO.getNome(),objDTO.getEmail());
	}
	public void delete(String id){
		findById(id);
		repo.deleteById(id);
	}
}
