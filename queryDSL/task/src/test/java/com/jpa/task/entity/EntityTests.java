package com.jpa.task.entity;

import com.jpa.task.repository.post.PostRepository;
import com.jpa.task.repository.reply.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class EntityTests {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void savePostTest(){
//        게시글 3개 제작
        final List<Post> posts = new ArrayList<>(Arrays.asList(
                Post.builder().postTitle("테스트 제목1").postContent("테스트 내용1").build(),
                Post.builder().postTitle("테스트 제목2").postContent("테스트 내용2").build(),
                Post.builder().postTitle("테스트 제목3").postContent("테스트 내용3").build()
        ));

//        게시글 3개 한 번에 저장
        postRepository.saveAll(posts);
    }

    @Test
    public void saveReplyTest(){
        Post post = postRepository.findById(781L).get();
//        게시글 조회 후 해당 게시글에 댓글 작성
//        final Reply reply = replyRepository.save(Reply.builder().replyContent("댓글 테스트1").depth(1L).post(post).build());
////        댓글은 처음부터 group_id를 추가할 수 없기 때문에
////        초기값을 NULL로 INSERT하고 추가된 댓글의 번호를 가져와서 UPDATE한다.
//        reply.setGroupId(reply.getId());

//        대댓글을 작성할 댓글 조회
        final Reply reply = replyRepository.findById(785L).get();
//        해당 댓글에 대댓글 작성, group_id에는 댓글의 번호를 작성한다.
//        depth는 2가 된다.
        replyRepository.save(Reply.builder().replyContent("대댓글 테스트1").groupId(reply.getId()).depth(2L).post(post).build());

    }
}
