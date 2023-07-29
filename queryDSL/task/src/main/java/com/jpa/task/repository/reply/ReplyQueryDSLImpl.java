package com.jpa.task.repository.reply;

import com.jpa.task.entity.QReply;
import com.jpa.task.entity.Reply;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.jpa.task.entity.QReply.reply;

@RequiredArgsConstructor
public class ReplyQueryDSLImpl implements ReplyQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public List<Reply> findAll_QueryDSL(Long id) {
        return query.selectFrom(reply).where(reply.post.id.eq(id).and(reply.depth.eq(1L))).fetch();
    }

    @Override
    public List<Reply> findRereplyAll_QueryDSL(Long groupId, Long depth) {
        return query.selectFrom(reply).where(reply.groupId.eq(groupId).and(reply.depth.eq(depth))).fetch();
    }
}
