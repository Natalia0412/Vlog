package com.example.teste.controller;

import com.example.teste.model.album.Album;
import com.example.teste.model.comment.Comment;
import com.example.teste.model.photo.Photo;
import com.example.teste.model.post.Post;
import com.example.teste.model.temp.CompleteUserTemp;
import com.example.teste.model.temp.PostCommentTemp;
import com.example.teste.model.temp.UserALbumTemp;
import com.example.teste.model.todo.Todo;
import com.example.teste.model.user.User;
import com.example.teste.repository.BlogClient;
import com.example.teste.service.AlbumService;
import com.example.teste.service.ListTesteService;
import com.example.teste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class ListTesteController {
    @Autowired
    private ListTesteService service;
    @Autowired
    private BlogClient blogClient;
    @GetMapping("/teste1")
    public Album teste1() {
        return service.teste1("a", 1, 2);
    }

    @GetMapping("/teste2")
    public Album teste2() {
        Album album = Album.builder().id(1).title("Lugs").userId(2).build();
        return service.teste2(album);
    }

    @GetMapping("/teste3")
    public List<String> teste3() {
        List<Integer> te = List.of(1, 2, 3);
        return service.teste3(te);
    }

    @GetMapping("/teste4")
    public List<String> teste4() {
        List<String> te = List.of("2", "3", "4", "abacaxi", "maça", "uva");
        return service.teste4(te);
    }

    @GetMapping("/teste5")
    public List<Integer> teste5() {
        List<Integer> te = List.of(1, 2, 3, 4);
        return service.teste5(te);
    }

    @GetMapping("/teste6")
    public List<String> teste6() {
        List<String> t = List.of("abelha", "mel", "arroz");
        return service.teste6(t);
    }

    @GetMapping("/teste7")
    public List<String> teste7() {
        Album al1=Album.builder()
                .id(1)
                .title("Paranoid")
                .userId(3).build();
        Album al2=Album.builder()
                .id(2)
                .title("High As Hope")
                .userId(3).build();
        List<Album> t = List.of(al1,al2);
        return service.teste7(t);
    }
    @GetMapping("/teste8")
    public List<Integer> teste8() {
        Album al1=Album.builder()
                .id(1)
                .build();
        Album al2=Album.builder()
                .id(2)
                .build();
        List<Album> t = List.of(al1,al2);
        return service.teste8(t);
    }

    @GetMapping("/teste9")
    public List<Integer> teste9(){
        List<Integer> par=List.of(1,2,3,4);
        return service.teste9(par);
    }

    @GetMapping("/teste10")
    public List<Integer> teste10(){
        List<Integer> maior=List.of(1,2,3,4,5,6,7,0);
        return service.teste10(maior);
    }
    @GetMapping("/teste11")
    public Album teste11(){
        Album al1=Album.builder()
                .id(1)
                .title("Lugs")
                .userId(3)
                .build();
        Album al2=Album.builder()
                .id(2)
                .title("Paranoid")
                .userId(3)
                .build();
        Album al3=Album.builder()
                .id(3)
                .title("Cowboys from Hell")
                .userId(4)
                .build();
        List<Album> busca=List.of(al1,al2,al3);
        Integer n=4;
        return service.teste11(busca,n);
    }

    @GetMapping("/teste12")
    public Integer teste12(){
       List <Integer> n= List.of(1,2);
        return service.teste12(n);
    }
    @GetMapping("/teste13")
    public Integer teste13(){
        List <Integer> n= List.of(4,2);
        return service.teste13(n);
    }
    @GetMapping("/teste14")
    public Integer teste14(){
        List <Integer> expo= List.of(4,2);
        return service.teste14(expo);
    }
    @GetMapping("/teste15")
    public List<UserALbumTemp> teste15(){
        List<Album> albuns=blogClient.getAllAlbums();
        List<User> users=blogClient.getAllUsers();
        return service.teste15(albuns,users);
    }
    @GetMapping("/teste16")
    public List<PostCommentTemp> teste16(){
        List<Comment> comments=blogClient.getAllComments();
        List<Post> posts=blogClient.getAllPosts();
        return service.teste16(comments,posts);
    }
    @GetMapping("/teste17")
    public List<CompleteUserTemp> teste17(){
        List<Album> albuns=blogClient.getAllAlbums();
        List<Comment> comments=blogClient.getAllComments();
        List<Post> posts=blogClient.getAllPosts();
        List<User> users=blogClient.getAllUsers();
        List<Todo> todos=blogClient.getAllTdo();
        List<Photo>photos=blogClient.getAllPhotos();
        return service.teste17(albuns,comments,posts,users,todos,photos);
    }

    @GetMapping("/teste18")
    public List<User> teste18(){
        List<User>users=blogClient.getAllUsers();
        return service.teste18(users);
    }

    @GetMapping("/teste19")
    public List<CompleteUserTemp> teste19(){
        List<CompleteUserTemp>users=teste17();
        return service.teste19(users);
    }
    @GetMapping("/teste20")
    public List<CompleteUserTemp> teste20(){
        List<CompleteUserTemp>users=teste17();
        return service.teste19(users);
    }

    @GetMapping("/teste21")
    public List<CompleteUserTemp> teste21(){
        List<CompleteUserTemp>users=teste17();
        return service.teste21(users);
    }





}