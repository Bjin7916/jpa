package com.jpa.task.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyDTO {
    private Long id;
    private String replyContent;
    private Long groupId;
    private Long depth;

    @Builder
    public ReplyDTO(Long id, String replyContent, Long groupId, Long depth) {
        this.id = id;
        this.replyContent = replyContent;
        this.groupId = groupId;
        this.depth = depth;
    }
}
