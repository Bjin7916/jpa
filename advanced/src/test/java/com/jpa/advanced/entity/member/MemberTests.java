package com.jpa.advanced.entity.member;

import com.jpa.advanced.repository.member.FileDAO;
import com.jpa.advanced.repository.member.MemberDAO;
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
public class MemberTests {

    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private FileDAO fileDAO;

    @Test
    public void saveTest(){
        Member member = new Member();
        File file = new File();

        MemberAddress memberAddress = new MemberAddress();

        memberAddress.setMemberAddress("강남구 청담동");
        memberAddress.setMemberAddressDetail("펜트하우스");
        memberAddress.setMemberZipcode("7777");

        member.setMemberEmail("ljm1234@gmail.com");
        member.setMemberId("ljm1234");
        member.setMemberPassword("1234");
        member.setMemberAddress(memberAddress);

        file.setFileName("자신감.png");
        file.setFilePath("2023/06/25");
        file.setFileSize(41894L);
        file.setFileUuid(UUID.randomUUID().toString());
        file.setMember(member);

        memberDAO.save(member);
        fileDAO.save(file);
    }
}
