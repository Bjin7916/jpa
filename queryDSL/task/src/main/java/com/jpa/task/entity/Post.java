package com.jpa.task.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_POST")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String postTitle;
    @NotNull private String postContent;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "post")
    private List<Reply> replies = new ArrayList<>();

    @Builder
    public Post(@NotNull String postTitle, @NotNull String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
    }
}
