package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.user.Company;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
//    경기도에 위치한 기업 회원의 아이디 뒤에 3을 붙이자!
    
//    벌크 연산: 여러 개 수정
//    [1]
//    벌크 연산시, 1차 캐시를 통과하지 않고 바로 쿼리가 발생된다.
//    따라서 수정 전 데이터가 1차 캐시에 등록되어 있다면, 수정 후에도 수정 전 데이터로 작업하게 된다.
//    항상 벌크 연산 수행 시에는 clearAutomatically=true를 사용하여 다음 조회 때에는 수정 후의 데이터를 조회하도록 설정해야 한다.

//    [2]
//    벌크 연산 시, Auditing Listener가 실행되지 않기 때문에 직접 수정 날짜를 현재 시간으로 변경해야 한다.
    @Modifying(clearAutomatically=true)
    @Query("update Company c set c.userId = concat(c.userId, :number), c.updatedDate = current_timestamp where c.address.address = :address")
    public void updateUserIdByAddress(String number, String address);

    @Query("select c from Company c where c.userName = :name")
    public Optional<Company> findByUserName(@Param("name") String userName);
}












