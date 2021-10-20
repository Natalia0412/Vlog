package com.example.teste.model.temp;

import com.example.teste.model.photo.Photo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteAlbumTemp {
    private Integer userId;
    private Integer id;
    private String title;
    private List<Photo> photos;
}
