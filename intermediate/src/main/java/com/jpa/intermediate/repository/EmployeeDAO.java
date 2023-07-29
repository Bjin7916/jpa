package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.employee.Developer;
import com.jpa.intermediate.entity.employee.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public Employee save(Employee employee){
        entityManager.persist(employee);
        return employee;
    }

//    조회
    public Optional<Developer> findById(Long id){
        return Optional.ofNullable(entityManager.find(Developer.class, id));
    }

//    개발자 조회
    public List<Developer> findAllByDeveloper(Integer projectCount){
//    public List<Developer> findAllByDeveloper(){
//        String query = "select e from Employee e where type(e) in (Developer)";

//        treat을 사용하면 부모 엔티티로 조회하며, 결과도 부모 객체로 받아야 한다.
//        String query = "select e from Employee e where treat(e as Developer).projectCount = :projectCount";

//        treat을 사용하지 않고 직접 from절에 원하는 자식 엔티티로 조회하면 위 문제는 해결된다.
        String query = "select d from Developer d where d.projectCount = :projectCount";
        return entityManager.createQuery(query, Developer.class)
                .setParameter("projectCount", projectCount)
                .getResultList();
    }

//    전체 조회
    public List<Employee> findAll(){
        String query = "select e from Employee e";
        return entityManager.createQuery(query, Employee.class).getResultList();
    }

//    삭제
    public void delete(Employee employee){
        entityManager.remove(employee);
    }
}
