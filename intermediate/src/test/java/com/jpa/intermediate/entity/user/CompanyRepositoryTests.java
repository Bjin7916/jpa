package com.jpa.intermediate.entity.user;

import com.jpa.intermediate.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CompanyRepositoryTests {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void saveTest(){
        Company company = new Company();
        Address address = new Address();

        address.setAddress("경기도");

        company.setBusinessNumber("1234");
        company.setUserId("kakao");
        company.setAddress(address);
        company.setUserName("카카오");
        company.setUserPassword("1234");

        companyRepository.save(company);
    }

    @Test
    public void updateTest(){
//        findById(): 쿼리 발생 전 1차 캐시 검사 후 존재하면 1차 캐시 객체로 사용
//        findAll(): 쿼리 발생 후 1차 캐시 검사 후 존재하면 1차 캐시 객체로 사용

        List<Company> companies = companyRepository.findAll();
//        Company company = companyRepository.findById(1L).get();
        companyRepository.updateUserIdByAddress("1", "경기도");
        companyRepository.updateUserIdByAddress("3", "서울");
//        company = companyRepository.findById(1L).get();
//        log.info(company.toString());
        companies = companyRepository.findAll();
        log.info(companies.toString());
    }

    @Test
    public void auditingTest(){
//        companyRepository.findById(1L).get().setUserName("updated");
        companyRepository.findByUserName("updated2").get().setUserName("updated3");
    }

}

















