package com.example.teste.service;

import com.example.teste.model.album.Album;
import com.example.teste.model.album.AlbumDomain;
import com.example.teste.model.post.Post;
import com.example.teste.repository.AlbumRepository;
import com.example.teste.repository.BlogClient;
import com.example.teste.utils.AlbumConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    @Autowired
    private BlogClient client;
    @Autowired
    private AlbumRepository repository;
    public List<Album> getAll() {
      /*  List<Integer> teste=List.of(1,2,3);
        List<String> teste2=teste.stream().map(tst -> tst.toString()).collect(Collectors.toList());
        List<Integer> teste3=teste.stream().map(tst->tst*tst).collect(Collectors.toList());*/
        return repository.findAll().stream().map(AlbumConverter::domainToObject).collect(Collectors.toList());
    }

    public Album getById(Integer id) {
        return AlbumConverter.domainToObject(repository.findById(id)
                .orElseThrow());
    }

    public Album update(Album request, Integer id){
        getById(id);
        request.setId(id);
        return AlbumConverter.domainToObject(repository.save(AlbumConverter.objectToDomain(request)));
    }
    public void delete(Integer id){
        getById(id);
        repository.deleteById(id);
    }

    public Album create(Album request){
        return AlbumConverter.domainToObject(repository.save(AlbumConverter.objectToDomain(request)));
    }

   /* public void seed(){
        repository.deleteAll();
        List<Album> albums= client.getAllAlbums();
        repository.saveAll(albums);
    }*/

    public void seed(){
        repository.deleteAll();
        List<Album> albums= client.getAllAlbums();
        List<AlbumDomain> toSave=albums.stream().map(album->AlbumConverter.objectToDomain(album)).collect(Collectors.toList());
        repository.saveAll(toSave);

    }


}
