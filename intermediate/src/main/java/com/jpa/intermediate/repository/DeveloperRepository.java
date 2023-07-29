package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.employee.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
//    개발자 중에서 프로젝트 수가 2개가 아닌 개발자 조회
    public List<Developer> findByProjectCountNot(int projectCount);
//    개발자 중에서 개발 레벨이 3이상인 개발자 조회
    public List<Developer> findByDeveloperLevelGreaterThanEqual(int developerLevel);
//    개발자 중에서 80년생 조회
    @Query("select d from Developer d where function('to_char', d.employeeBirth, 'YY') = '80'")
    public List<Developer> findByEmployeeBirthOf80();

}
