package com.example.teste.repository;

import com.example.teste.model.album.Album;
import com.example.teste.model.comment.Comment;
import com.example.teste.model.photo.Photo;
import com.example.teste.model.post.Post;
import com.example.teste.model.todo.Todo;
import com.example.teste.model.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
@FeignClient(name="jsonPlaceholder",url="https://jsonplaceholder.typicode.com")
public interface BlogClient {
    @GetMapping("/posts/{id}")
    Post getPostId(@PathVariable Integer id);
    @GetMapping("/posts")
    List<Post> getAllPosts();

    @GetMapping("/comments")
    List<Comment>getAllComments();

    @GetMapping("/albums")
    List<Album>getAllAlbums();

    @GetMapping("/photos")
    List<Photo>getAllPhotos();

    @GetMapping("/todos")
    List<Todo> getAllTdo();

    @GetMapping("/users")
    List<User> getAllUsers();
}


