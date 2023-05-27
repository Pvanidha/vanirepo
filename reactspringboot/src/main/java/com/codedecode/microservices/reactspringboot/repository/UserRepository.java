package com.codedecode.microservices.reactspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codedecode.microservices.reactspringboot.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{

}
