package com.example.teste.service;

import com.example.teste.model.post.Post;
import com.example.teste.repository.BlogClient;
import com.example.teste.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private BlogClient client;
    @Autowired
    private PostRepository repository;
    public List<Post> getAll() {
        return repository.findAll();
    }
    public Post update(Post request,Integer id){
        getById(id);
        request.setId(id);
        return repository.save(request);
    }
    public Post create(Post request){
        return repository.save(request);
    }

    public Post getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
    public void delete(Integer id){
        getById(id);
        repository.deleteById(id);
    }
    public void seed(){
        //deleta todos da minha base de dados, vai na api e pega os dados novamente
        repository.deleteAll();
        List<Post> posts= client.getAllPosts();
        repository.saveAll(posts);
    }
}
