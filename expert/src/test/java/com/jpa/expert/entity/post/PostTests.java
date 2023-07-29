package com.jpa.expert.entity.post;

import com.jpa.expert.repository.post.LikeDAO;
import com.jpa.expert.repository.post.PostDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class PostTests {
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private LikeDAO likeDAO;

    @Test
    public void saveTest(){
//        Post post = new Post();
        Post post = postDAO.findById(25L).get();
        Like like1 = new Like();
        Like like2 = new Like();

//        post.setPostTitle("테스트 제목1");
//        post.setPostContent("테스트 내용1");

        post.setLike(like1);
        post.setLike(like2);

//        postDAO.save(post);
    }

    @Test
    public void findByIdTest(){
        Post post = postDAO.findById(25L).get();
        log.info(post.toString());
    }

    @Test
    public void findAllTest(){
        postDAO.findAll().stream().map(Post::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        Post post = new Post();
        Like like = likeDAO.findById(26L).get();

        post.setPostTitle("테스트 제목1");
        post.setPostContent("테스트 내용1");

        post.setLike(like);
        postDAO.save(post);
    }

    @Test
    public void deleteTest(){
        final Optional<Post> foundPost = postDAO.findById(25L);
        foundPost.ifPresent(postDAO::delete);
    }
}


















