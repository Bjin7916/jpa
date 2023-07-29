package com.jpa.intermediate.entity.file;

import com.jpa.intermediate.repository.MemberFileRepository;
import com.jpa.intermediate.repository.PostFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class PostFileRepositoryTests {
    @Autowired
    private PostFileRepository postFileRepository;

    @Test
    public void saveTest(){
        IntStream.range(0, 50).forEach(i -> {
            int date = (i % 30) + 1;
            PostFile postFile = new PostFile();

            postFile.setPostContent("테스트 내용" + (i + 1));
            postFile.setFilePath("2023/07/" + (date < 10 ? "0" + date : date));
            postFile.setUuid(UUID.randomUUID().toString());
            postFile.setFileName("파일명" + (i + 1) + ".png");
            postFile.setFileSize(1896416L);
            postFileRepository.save(postFile);
        });
    }

    @Test
    public void findAllByFilePathsTest(){
        postFileRepository.findAllByFilePaths(new ArrayList<>(Arrays.asList("2023/07/20", "2023/07/30", "2023/07/01")))
                .forEach(postFile -> log.info(postFile.toString()));
    }
}


























