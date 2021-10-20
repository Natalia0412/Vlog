package com.example.teste.model.album;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Getter
@Setter
public class AlbumDomain {
    private Integer userId;
    @Id
    private Integer id;
    private String title;
}
