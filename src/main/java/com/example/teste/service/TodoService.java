package com.example.teste.service;

import com.example.teste.model.post.Post;
import com.example.teste.model.todo.Todo;
import com.example.teste.repository.BlogClient;
import com.example.teste.repository.PhotoRepository;

import com.example.teste.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {
    @Autowired
    private BlogClient client;
    @Autowired
    private TodoRepository repository;
    public List<Todo> getAll() {
        return repository.findAll();
    }
    public Todo update(Todo request,Integer id){
        getById(id);
        request.setId(id);
        return repository.save(request);
    }
    public Todo create(Todo request){
        return repository.save(request);
    }

    public Todo getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
    public void delete(Integer id){
        getById(id);
        repository.deleteById(id);
    }
    public void seed(){
        //deleta todos da minha base de dados, vai na api e pega os dados novamente
        repository.deleteAll();
        List<Todo> todos= client.getAllTdo();
        repository.saveAll(todos);
    }
}
