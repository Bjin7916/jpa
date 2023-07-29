package com.jpa.task.repository.reply;

import com.jpa.task.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long>, ReplyQueryDSL {
}
