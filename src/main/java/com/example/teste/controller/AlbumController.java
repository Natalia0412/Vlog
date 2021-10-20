package com.example.teste.controller;

import com.example.teste.model.album.Album;
import com.example.teste.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService service;
    @GetMapping
    public List<Album> getAllAlbums(){
        return service.getAll();
    }
    @PostMapping
    public Album addAlbum(@RequestBody Album insertAlbum){
        return service.create(insertAlbum);
    }
    @GetMapping("/{id}")
    public Album getById (@PathVariable("id") Integer id){
        return service.getById(id);
    }
    @PutMapping("/{id}")
    public Album update(@RequestBody Album request, @PathVariable("id")Integer id){
        return service.update(request,id);
    }
    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable("id")Integer id){
        service.delete(id);
    }
    @PostMapping("/seed")
    public void seed(){
        service.seed();
    }

}
