package com.example.wssbd.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.wssbd.Domain.User;
@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
