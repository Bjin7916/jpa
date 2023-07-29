package com.jpa.task.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_REPLY")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String replyContent;
    private Long groupId;
    @NotNull private Long depth;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Builder
    public Reply(@NotNull String replyContent, Long groupId, @NotNull Long depth, Post post) {
        this.replyContent = replyContent;
        this.groupId = groupId;
        this.depth = depth;
        this.post = post;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
