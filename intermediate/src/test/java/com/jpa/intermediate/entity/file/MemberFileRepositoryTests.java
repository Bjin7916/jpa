package com.jpa.intermediate.entity.file;

import com.jpa.intermediate.repository.MemberFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MemberFileRepositoryTests {
    @Autowired
    private MemberFileRepository memberFileRepository;

    @Test
    public void saveTest(){
        MemberFile memberFile = new MemberFile();
        memberFile.setMemberName("이순신");
        memberFile.setFilePath("2023/07/02");
        memberFile.setUuid(UUID.randomUUID().toString());
        memberFile.setFileName("데일리.png");
        memberFile.setFileSize(1896416L);

        memberFileRepository.save(memberFile);
    }

    @Test
    public void findAllTest(){
        log.info(memberFileRepository.findAll().toString());
    }

    @Test
    public void findAllByFileNamesTest(){
        assertThat(memberFileRepository.findAllByFileNames(new ArrayList<>(Arrays.asList("전성기.png", "현재.png"))))
                .hasSize(2);
    }
}


























