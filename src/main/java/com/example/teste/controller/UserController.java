package com.example.teste.controller;

import com.example.teste.model.post.Post;
import com.example.teste.model.user.User;
import com.example.teste.service.PostService;
import com.example.teste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/{id}")
    public User getById (@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @GetMapping
    public List<User> getAllUser(){
        return service.getAll();
    }
    @PostMapping
    public User addUser(@RequestBody User insertUser){ return service.create(insertUser);}
    @PutMapping("/{id}")
    public User update(@RequestBody User request, @PathVariable("id") Integer id){
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
