package com.jpa.task.service;

import com.jpa.task.domain.ReplyDTO;
import com.jpa.task.repository.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;

    @Override
    public List<ReplyDTO> getList(Long id) {
        return replyRepository.findAll_QueryDSL(id).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReplyDTO> getRereplies(Long groupId, Long depth) {
        return replyRepository.findRereplyAll_QueryDSL(groupId, depth).stream().map(this::toDTO).collect(Collectors.toList());
    }
}
