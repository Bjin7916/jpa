package com.jpa.task.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Data
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Integer replyCount;

    @Builder
    public PostDTO(Long id, String postTitle, String postContent) {
        this.id = id;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }
}
