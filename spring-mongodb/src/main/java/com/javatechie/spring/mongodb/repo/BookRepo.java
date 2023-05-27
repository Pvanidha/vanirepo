package com.javatechie.spring.mongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongodb.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer>{

}
