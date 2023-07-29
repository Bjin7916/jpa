package com.jpa.intermediate.entity.employee;

import com.jpa.intermediate.repository.DeveloperRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class DeveloperRepositoryTests {
    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    public void saveTest(){
        Developer developer = new Developer();
        developer.setEmployeeName("한동석");
        developer.setEmployeeCareer(7);
        developer.setEmployeeBirth(LocalDate.of(1980, 12, 04));
        developer.setProjectCount(10);
        developer.setDeveloperLevel(3);

        developerRepository.save(developer);
    }

    @Test
    public void findByProjectCountNotTest(){
        log.info(developerRepository.findByProjectCountNot(2).get(0).toString());
    }

    @Test
    public void findByDeveloperLevelGreaterThanEqualTest(){
        log.info(developerRepository.findByDeveloperLevelGreaterThanEqual(3).toString());
    }

    @Test
    public void findByEmployeeBirthOf80Test(){
        log.info(developerRepository.findByEmployeeBirthOf80().get(0).toString());
    }
}
