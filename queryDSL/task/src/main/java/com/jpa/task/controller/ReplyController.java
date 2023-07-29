package com.jpa.task.controller;

import com.jpa.task.domain.ReplyDTO;
import com.jpa.task.service.ReplyService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies/api/*")
public class ReplyController {
    private final ReplyService replyService;
    
//    댓글 목록
    @GetMapping("{id}")
    public List<ReplyDTO> getList(@PathVariable Long id){
        return replyService.getList(id);
    }

//    대댓글 조회
    @GetMapping("{groupId}/{depth}")
    public List<ReplyDTO> getReReplyList(@PathVariable Long groupId, @PathVariable Long depth){
        return replyService.getRereplies(groupId, depth);
    }
}
