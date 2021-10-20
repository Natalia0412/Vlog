package com.example.teste.controller;

import com.example.teste.model.post.Post;
import com.example.teste.model.todo.Todo;
import com.example.teste.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/todo")
@RestController
public class TodoController {
    @Autowired
    private TodoService service;
    @GetMapping("/{id}")
    public Todo getById (@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @GetMapping
    public List<Todo> getAllPosts(){
        return service.getAll();
    }
    @PostMapping
    public Todo addPost(@RequestBody Todo insertTodo){ return service.create(insertTodo);}
    @PutMapping("/{id}")
    public Todo update(@RequestBody Todo request, @PathVariable("id") Integer id){
        return service.update(request, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }

    @PostMapping("/seed")
    public void seed(){
        service.seed();
    }
}
