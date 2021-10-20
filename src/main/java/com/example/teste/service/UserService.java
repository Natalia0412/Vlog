package com.example.teste.service;

import com.example.teste.model.post.Post;
import com.example.teste.model.user.User;
import com.example.teste.repository.BlogClient;
import com.example.teste.repository.PostRepository;
import com.example.teste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private BlogClient client;
    @Autowired
    private UserRepository repository;
    public List<User> getAll() {
        return repository.findAll();
    }
    public User update(User request,Integer id){
        getById(id);
        request.setId(id);
        return repository.save(request);
    }
    public User create(User request){
        return repository.save(request);
    }

    public User getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
    public void delete(Integer id){
        getById(id);
        repository.deleteById(id);
    }
    public void seed(){
        //deleta todos da minha base de dados, vai na api e pega os dados novamente
        repository.deleteAll();
        List<User> users= client.getAllUsers();
        repository.saveAll(users);
    }
}
