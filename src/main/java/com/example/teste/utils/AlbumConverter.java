package com.example.teste.utils;

import com.example.teste.model.album.Album;
import com.example.teste.model.album.AlbumDomain;

public class AlbumConverter {
    public static Album domainToObject(AlbumDomain domain){
        return Album.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .userId(domain.getUserId())
                .build();
    }

    public static AlbumDomain objectToDomain(Album object){
        return AlbumDomain.builder()
                .id(object.getId())
                .title(object.getTitle())
                .userId(object.getUserId())
                .build();

    }
}
