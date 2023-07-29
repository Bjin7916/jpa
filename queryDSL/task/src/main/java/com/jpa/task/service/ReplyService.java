package com.jpa.task.service;

import com.jpa.task.domain.ReplyDTO;
import com.jpa.task.entity.Reply;

import java.util.List;

public interface ReplyService {
//    댓글 목록
    public List<ReplyDTO> getList(Long id);

//    댓글 조회(대댓글 목록)
    public List<ReplyDTO> getRereplies(Long groupId, Long depth);

    public default ReplyDTO toDTO(Reply reply){
        return ReplyDTO.builder()
                .id(reply.getId())
                .replyContent(reply.getReplyContent())
                .groupId(reply.getGroupId())
                .depth(reply.getDepth())
                .build();
    }
}
