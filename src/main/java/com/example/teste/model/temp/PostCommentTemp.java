package com.example.teste.model.temp;

import com.example.teste.model.comment.Comment;
import com.example.teste.model.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentTemp {
    private Post post;
    private List<Comment> comments;
}
