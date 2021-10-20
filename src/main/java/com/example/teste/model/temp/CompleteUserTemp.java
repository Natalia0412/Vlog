package com.example.teste.model.temp;

import com.example.teste.model.album.Album;
import com.example.teste.model.post.Post;
import com.example.teste.model.todo.Todo;
import com.example.teste.model.user.UserAddress;
import com.example.teste.model.user.Usercompany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteUserTemp {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private UserAddress address;
    private String phone;
    private String website;
    private Usercompany company;
    private List<CompletePostTemp> posts;
    private List<CompleteAlbumTemp> albums;
    private List<Todo> todos;


}
