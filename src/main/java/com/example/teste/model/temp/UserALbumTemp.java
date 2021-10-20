package com.example.teste.model.temp;

import com.example.teste.model.album.Album;
import com.example.teste.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserALbumTemp {
    private User user;
    private List<Album> albuns;
}
