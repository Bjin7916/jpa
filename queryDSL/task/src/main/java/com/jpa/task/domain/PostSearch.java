package com.jpa.task.domain;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostSearch {
    private String postTitle;
    private String postContent;
    private Integer replyCount;
}
