package com.jpa.advanced.entity.hospital;

import com.jpa.advanced.repository.hospital.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class OwnerRepositoryTests {
    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void saveTest(){
        Owner owner = new Owner();
        owner.setOwnerName("한동석");
        owner.setOwnerPhone("01012341234");

        ownerRepository.save(owner);
    }

    @Test
    public void findAllTest(){
        log.info(ownerRepository.findAll().toString());
    }
}





















