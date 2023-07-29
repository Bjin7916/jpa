package com.jpa.advanced.entity.post;

import com.jpa.advanced.repository.post.PostDAO;
import com.jpa.advanced.repository.post.ReplyDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class PostTests {
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private ReplyDAO replyDAO;

    @Test
    public void saveTest() {
        Post post = new Post();
//        final Optional<Post> foundPost = postDAO.findById(1L);
        Reply reply1 = new Reply();
        Reply reply2 = new Reply();

//        if(foundPost.isPresent()){
//            Post post = foundPost.get();
//            reply1.setReplyContent("테스트 댓글 1");
//            reply1.setPost(post);
//
//            reply2.setReplyContent("테스트 댓글 2");
//            reply2.setPost(post);
//
//            replyDAO.save(reply1);
//            replyDAO.save(reply2);
//        }
        post.setPostTitle("테스트 제목 1");
        post.setPostContent("테스트 내용 1");
//
//        postDAO.save(post);

        reply1.setReplyContent("테스트 댓글 1");
        reply1.setPost(post);

        reply2.setReplyContent("테스트 댓글 2");
        reply2.setPost(post);

        replyDAO.save(reply1);
        replyDAO.save(reply2);
//
//        post.setPostTitle("테스트 제목 1");
//        post.setPostContent("테스트 내용 1");
//        post.getReplies().add(reply1);
//        post.getReplies().add(reply2);
//
//        postDAO.save(post);
    }

    @Test
    public void findByIdTest() {
//        postDAO.findById(1L).ifPresent(post -> log.info(post.getPostContent()));
//        postDAO.findById(1L).map(Post::toString).ifPresent(log::info);
//        replyDAO.findById(2L).ifPresent(reply -> log.info(reply.getReplyContent()));
//        replyDAO.findById(3L).map(Reply::toString).ifPresent(log::info);
    }

    @Test
    public void findAllTest() {
//        postDAO.findAll().stream().map(Post::getPostTitle).forEach(log::info);
//        postDAO.findAll().stream().map(Post::getReplies).forEach(replies -> replies.forEach(reply -> log.info(reply.getReplyContent())));
//        log.info(postDAO.findAll().toString());
    }

    @Test
    public void updateTest() {
//        final Optional<Post> foundPost = postDAO.findById(1L);
//        if (foundPost.isPresent()) {
//            Post post = foundPost.get();
//            final List<Reply> replies = post.getReplies();
//
//            for (Reply reply : replies) {
//                if(reply.getId() == 2L){
//                    reply.setReplyContent("수정된 댓글");
//                }
//            }
//        }

//        replyDAO.findById(2L).ifPresent(reply -> reply.getPost().setPostTitle("수정된 제목"));
    }

    @Test
    public void deleteTest(){
//        replyDAO.findById(4L).ifPresent(reply -> postDAO.delete(reply.getPost()));
//        postDAO.findById(4L).ifPresent(post -> post.getReplies().forEach(replyDAO::delete));
//        replyDAO.findById(4L).ifPresent(replyDAO::delete);
//        postDAO.findById(1L).ifPresent(postDAO::delete);
    }
}
























