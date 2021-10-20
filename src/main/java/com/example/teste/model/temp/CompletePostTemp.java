package com.example.teste.model.temp;

import com.example.teste.model.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompletePostTemp {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    private List<Comment>comments;
}
