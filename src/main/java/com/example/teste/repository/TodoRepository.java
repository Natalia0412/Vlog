package com.example.teste.repository;

import com.example.teste.model.todo.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo,Integer> {
}
