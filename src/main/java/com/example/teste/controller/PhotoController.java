package com.example.teste.controller;

import com.example.teste.model.photo.Photo;
import com.example.teste.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private PhotoService service;



    @GetMapping("/{id}")
    public Photo getById(@PathVariable("id")Integer id){
        return service.getById(id);
    }
    @GetMapping
    public List<Photo> getAllPhotos(){
        return service.getAll();
    }
    @PostMapping
    public Photo addPhoto(@RequestBody Photo insertPhoto){ return service.create(insertPhoto);}
    @PutMapping("/{id}")
    public Photo update(@RequestBody Photo request, @PathVariable("id") Integer id){
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


