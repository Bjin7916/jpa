package com.jpa.task.repository;

import com.jpa.task.repository.post.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class RepositoryTests {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void findAllWithReplyCountTest(){
        log.info(postRepository.findAllWithReplyCount().toString());
    }

}
