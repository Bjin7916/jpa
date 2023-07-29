package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.computer.Computer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class ComputerDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public Computer save(Computer computer) {
        entityManager.persist(computer);
        return computer;
    }

//    조회
    public Optional<Computer> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Computer.class, id));
    }

//    전체 조회
    public List<Computer> findAll() {
        String query = "select c from Computer c";
        return entityManager.createQuery(query, Computer.class).getResultList();
    }

//    메모리로 조회
    public List<Computer> findByRam(int ram){
        String query = "select c from Computer c where c.hardware.ram = :ram";
        return entityManager.createQuery(query, Computer.class)
                .setParameter("ram", ram)
                .getResultList();
    }

//    삭제
    public void delete(Computer computer){
        entityManager.remove(computer);
    }
}


















