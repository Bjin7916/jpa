package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.employee.Planner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlannerRepository extends JpaRepository<Planner, Long> {
    public Page<Planner> findAllByPlannerOaLevelIsNotNull(Pageable pageable);
    public List<Planner> findTop5ByOrderByClientCountDesc();
}
