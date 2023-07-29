package com.jpa.intermediate.entity.file;

import com.jpa.intermediate.repository.MemberFileDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class FileDaoTests {
    @Autowired
    private MemberFileDAO memberFileDAO;

    @Test
    public void saveTest(){
        MemberFile memberFile = new MemberFile();
        memberFile.setMemberName("한동석");
        memberFile.setFileName("전성기.png");
        memberFile.setFilePath("2023/06/18");
        memberFile.setUuid(UUID.randomUUID().toString());
        memberFile.setFileSize(15896496L);

        memberFileDAO.save(memberFile);
    }

    @Test
    public void findByIdTest(){
        memberFileDAO.findById(5L).ifPresent(memberFile -> {log.info(memberFile.toString());});
    }

    @Test
    public void findAllTest(){
        memberFileDAO.findAll().stream().map(MemberFile::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        memberFileDAO.findById(5L).ifPresent(memberFile -> memberFile.setFileName("현재.png"));
    }
}
