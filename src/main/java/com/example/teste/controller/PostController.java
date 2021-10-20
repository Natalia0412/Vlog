package com.example.teste.controller;

import com.example.teste.model.post.Post;
import com.example.teste.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/post")
@RestController
public class PostController {
    @Autowired
    private PostService service;
    @GetMapping("/{id}")
    public Post getById (@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @GetMapping
    public List<Post> getAllPosts(){
        return service.getAll();
    }
    @PostMapping
    public Post addPost(@RequestBody Post insertPost){ return service.create(insertPost);}
    @PutMapping("/{id}")
    public Post update(@RequestBody Post request, @PathVariable("id") Integer id){
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
