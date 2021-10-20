package com.example.teste.service;

import com.example.teste.model.photo.Photo;
import com.example.teste.model.post.Post;
import com.example.teste.repository.BlogClient;
import com.example.teste.repository.PhotoRepository;
import com.example.teste.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class PhotoService {
    @Autowired
    private BlogClient client;
    @Autowired
    private PhotoRepository repository;
    public List<Photo> getAll() {
        return repository.findAll();
    }

    public Photo update(Photo request,Integer id){
        getById(id);
        request.setId(id);
        return repository.save(request);
    }
    public Photo create(Photo request){
        return repository.save(request);
    }

    public Photo getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
    public void delete(Integer id){
        getById(id);
        repository.deleteById(id);
    }
    public void seed(){
        //deleta todos da minha base de dados, vai na api e pega os dados novamente
        repository.deleteAll();
        List<Photo> photos= client.getAllPhotos();
        repository.saveAll(photos);
    }

}