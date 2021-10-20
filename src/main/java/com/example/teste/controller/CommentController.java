package com.example.teste.controller;

import com.example.teste.model.comment.Comment;
import com.example.teste.model.post.Post;
import com.example.teste.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService service;
    @GetMapping("/{id}")
    public Comment getById (@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return service.getAll();
    }
    @PostMapping
    public Comment addComments(@RequestBody Comment insertComment){ return service.create(insertComment);}
    @PutMapping("/{id}")
    public Comment update(@RequestBody Comment request, @PathVariable("id") Integer id){
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
