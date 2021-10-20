package com.example.teste.repository;

import com.example.teste.model.photo.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo,Integer> {
}
