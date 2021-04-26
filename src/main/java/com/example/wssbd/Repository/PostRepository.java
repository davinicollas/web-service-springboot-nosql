package com.example.wssbd.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.wssbd.Domain.Post;
@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
