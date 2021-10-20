package com.example.teste.service;

import com.example.teste.model.album.Album;
import com.example.teste.model.comment.Comment;
import com.example.teste.model.photo.Photo;
import com.example.teste.model.post.Post;
import com.example.teste.model.temp.*;
import com.example.teste.model.todo.Todo;
import com.example.teste.model.user.User;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ListTesteService {
    public Album teste1(String a, Integer b, Integer l){
        return Album.builder()
                .id(l)
                .title(a)
                .userId(b)
                .build();

    }
    public Album teste2(Album album ){
        return Album.builder()
                .id(album.getId())
                .title(album.getTitle())
                .userId(album.getUserId())
                .build();


    }
    public List<String> teste3(List<Integer> lista){
        return lista.stream().map(l->(l*2)+"").collect(Collectors.toList());
    }
    public List<String> teste4(List<String> lista){
        return lista.stream().map(numerico->{
            try {
                return (Integer.parseInt(numerico)*2)+"";
            }
            catch (Exception e){
                return numerico;
            }
        }).collect(Collectors.toList());
    }
    //retornar numeros impares ao quadrado e dividir numeros pares por dois
    public List<Integer> teste5(List<Integer> numeros){
        return numeros.stream().map(n->{
            if(n%2==0){
                return n/2;
            }
            return n*n;
        }).collect(Collectors.toList());
    }
    public List<String> teste6(List<String> palavra){
        return palavra.stream().map(pa->pa+"-").collect(Collectors.toList());
    }
    public List<String> teste7(List<Album> palavra){
        return palavra.stream().map(albumPalavra->
                "id: "+albumPalavra.getId()+" Nome do album: "+albumPalavra.getTitle()+" Id do Usuário: "+albumPalavra.getUserId()).collect(Collectors.toList());
    }
    public List<Integer> teste8(List<Album> idAlbum){
        return idAlbum.stream().map(al->
                +al.getId()).collect(Collectors.toList());
    }

    public List<Integer> teste9(List<Integer> numeros){
        return numeros.stream()
                .filter(num->num%2==0)
                .collect(Collectors.toList());
    }

    public List<Integer> teste10(List<Integer> numeros){
        return numeros.stream()
                .filter(n->n>5)
                .collect(Collectors.toList());
    }
    public Album teste11(List<Album> albuns,Integer id){
        return albuns.stream()
                .filter(n->n.getId().equals(id))
                .findFirst().orElseThrow();
    }
    public Integer teste12(List<Integer>numeros){
        AtomicInteger soma= new AtomicInteger(0);
        numeros.stream().forEach(n-> soma.addAndGet(n));
        return soma.get();
    }

    public Integer teste13(List<Integer> n){
        AtomicInteger res=new AtomicInteger(1);
        n.stream().forEach(multi->res.updateAndGet(m->m*multi));
        return res.get();
    }
    public Integer teste14(List<Integer> n){
        AtomicInteger res=new AtomicInteger(n.get(0));

        n.stream().skip(1).forEach(multi->res.updateAndGet(m->(int)(Math.pow(m,multi))));
        return res.get();

    }


    public List<UserALbumTemp> teste15(List<Album> albuns, List<User> users) {
        return users.stream().map(user->{
                List<Album> userAlbuns=albuns.stream()
                    .filter(album -> album.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            return UserALbumTemp.builder().user(user).albuns(userAlbuns).build();
        }).collect(Collectors.toList());

    }

    public List<PostCommentTemp> teste16(List<Comment> comments, List<Post> posts) {
        return posts.stream().map(post -> {
            List<Comment> postComments=comments.stream()
                    .filter(comment -> comment.getPostId().equals(post.getId()))
                    .collect(Collectors.toList());
            return PostCommentTemp.builder().comments(postComments).post(post).build();
        }).collect(Collectors.toList());
    }


    public List<CompleteUserTemp> teste17(List<Album> albuns, List<Comment> comments, List<Post> posts, List<User> users, List<Todo> todos,List<Photo> photos) {
        return users.stream().map(user->{
           List<Album> userAlbuns=albuns.stream()
                  .filter(album -> album.getUserId().equals(user.getId()))
                   .collect(Collectors.toList());
           List<CompleteAlbumTemp> completeUserAlbuns=userAlbuns.stream().map(album -> {
               List<Photo> albumPhotos= photos.stream()
                       .filter(photo -> photo.getAlbumId().equals(album.getId()))
                       .collect(Collectors.toList());
               return CompleteAlbumTemp.builder()
                       .userId(album.getUserId())
                       .id(album.getId())
                       .title(album.getTitle())
                       .photos(albumPhotos)
                       .build();
           }).collect(Collectors.toList());
            List<Post> userPost=posts.stream()
                   .filter(post -> post.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            List<CompletePostTemp> completeUserPosts=userPost.stream().map(post -> {
                List<Comment> postComments=comments.stream()
                        .filter(comment -> comment.getPostId().equals(post.getId()))
                        .collect(Collectors.toList());
                return CompletePostTemp.builder()
                        .userId(post.getUserId())
                        .id(post.getId())
                        .title(post.getTitle())
                        .body(post.getBody())
                        .comments(postComments)
                        .build();
                }
            ) .collect(Collectors.toList());
            List<Todo> userTodo=todos.stream()
                    .filter(todo -> todo.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            return CompleteUserTemp.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .username(user.getUsername())
                    .email(user.getName())
                    .address(user.getAddress())
                    .phone(user.getPhone())
                    .website(user.getWebsite())
                    .company(user.getCompany())
                    .posts(completeUserPosts)
                    .albums(completeUserAlbuns)
                    .todos(userTodo)
                    .build();
        }).collect(Collectors.toList());
    }
    public List<User> teste18 (List<User> users ){
        return users.stream().filter(n->
           (n.getId()%2!=0)
        ).collect(Collectors.toList());
    }

    public List<CompleteUserTemp> teste19(List<CompleteUserTemp> users) {
        return users.stream().filter(n-> {
            Optional<CompleteAlbumTemp> found = n.getAlbums().stream()
                    .filter(album -> album.getId() > 20).findAny();
            return found.isPresent();
        }).collect(Collectors.toList());
    }

    public List<CompleteUserTemp> teste20(List<CompleteUserTemp> users){
        return users.stream().filter(user-> {
            Optional<CompleteAlbumTemp> albumFound = user.getAlbums().stream().filter(album -> {
                Optional<Photo> photoFound = album.getPhotos().stream().filter(photo -> photo.getId() > 20).findAny();
                return photoFound.isPresent();
            }).findAny();
            return albumFound.isPresent();
        }).collect(Collectors.toList());
    }


    public List<CompleteUserTemp> teste21(List<CompleteUserTemp> users) {
        return users.stream().filter(user->{
            Optional<CompletePostTemp> postsFound=user.getPosts().stream().filter(post->{
                Optional<Comment> commentFound=post.getComments().stream().filter(comment -> comment.getId()<50).findAny();
                return commentFound.isPresent();
            }).findAny();
            return postsFound.isPresent();
        }).collect(Collectors.toList());
    }

    public List<CompleteUserTemp> teste22(List<CompleteUserTemp> user){
        return null;
    }
}

