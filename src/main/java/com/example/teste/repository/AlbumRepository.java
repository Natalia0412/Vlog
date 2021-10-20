package com.example.teste.repository;

import com.example.teste.model.album.Album;
import com.example.teste.model.album.AlbumDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends MongoRepository <AlbumDomain,Integer> {
}
