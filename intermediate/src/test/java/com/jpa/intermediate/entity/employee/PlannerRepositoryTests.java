package com.jpa.intermediate.entity.employee;

import com.jpa.intermediate.repository.PlannerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class PlannerRepositoryTests {
    @Autowired
    private PlannerRepository plannerRepository;

    @Test
    public void saveTest() {
        for (int i = 0; i < 50; i++) {
            Planner planner = new Planner();
            planner.setEmployeeName("기획자" + (i + 1));
            planner.setEmployeeCareer(1 + (i % 20));
            planner.setEmployeeBirth(LocalDate.of(1980 + (i % 11), 1 + (i % 12), 1 + (i % 20)));
            planner.setPlannerOaLevel(1 + (i % 5));
            planner.setClientCount((i + 1) * 10);
            plannerRepository.save(planner);
        }
    }

    @Test
    public void findAllByPlannerOaLevelIsNotNullTest(){
        PageRequest pageRequest = PageRequest.of(3, 5, Sort.by(Sort.Direction.DESC, "id"));
//        plannerRepository.findAllByPlannerOaLevelIsNotNull(pageRequest).map(Planner::toString).forEach(log::info);
        final Page<Planner> pagingOfPlanner = plannerRepository.findAllByPlannerOaLevelIsNotNull(pageRequest);
        log.info("전체 페이지 개수: {}", String.valueOf(pagingOfPlanner.getTotalPages()));
        log.info("전체 정보: {}", String.valueOf(pagingOfPlanner.getTotalElements()));
        log.info("현재 페이지 번호: {}", String.valueOf(pagingOfPlanner.getNumber()));
        log.info("페이지 당 나오는 정보의 개수: {}", String.valueOf(pagingOfPlanner.getNumberOfElements()));
        log.info("다음 페이지 여부: {}", String.valueOf(pagingOfPlanner.hasNext()));
        log.info("이전 페이지 여부: {}", String.valueOf(pagingOfPlanner.hasPrevious()));
        log.info("현재 페이지가 첫 페이지인지 검사: {}", String.valueOf(pagingOfPlanner.isFirst()));
        log.info("현재 페이지가 마지막 페이지인지 검사: {}", String.valueOf(pagingOfPlanner.isLast()));
        log.info("정보: {}", pagingOfPlanner.getContent().toString());
    }

    @Test
    public void findTop5OrderByClientCountDescTest(){
        plannerRepository.findTop5ByOrderByClientCountDesc().stream().map(Planner::toString).forEach(log::info);
    }
}




















