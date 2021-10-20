package com.example.teste.service;

import com.example.teste.model.comment.Comment;
import com.example.teste.model.post.Post;
import com.example.teste.repository.BlogClient;
import com.example.teste.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private BlogClient client;
    @Autowired
    private CommentRepository repository;
    public List <Comment>getAll() {
        return repository.findAll();
    }
    public Comment update(Comment request, Integer id){
        getById(id);
        request.setId(id);
        return repository.save(request);
    }
    public Comment create(Comment request){
        return repository.save(request);
    }

    public Comment getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
    public void delete(Integer id){
        getById(id);
        repository.deleteById(id);
    }
    public void seed(){
        //deleta todos da minha base de dados, vai na api e pega os dados novamente
        repository.deleteAll();
        List<Comment> comments= client.getAllComments();
        repository.saveAll(comments);
    }


}
