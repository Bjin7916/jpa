package com.jpa.task.repository.reply;

import com.jpa.task.entity.Reply;

import java.util.List;

public interface ReplyQueryDSL {
//    댓글 목록
    public List<Reply> findAll_QueryDSL(Long id);

//    댓글 조회(대댓글 목록)
    public List<Reply> findRereplyAll_QueryDSL(Long groupId, Long depth);
}
