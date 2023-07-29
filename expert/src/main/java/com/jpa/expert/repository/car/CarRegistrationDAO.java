package com.jpa.expert.repository.car;

import com.jpa.expert.entity.car.CarRegistration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRegistrationDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //    자동차 등록증 추가
    public CarRegistration save(CarRegistration carRegistration){
        entityManager.persist(carRegistration);
        return carRegistration;
    }
    //    자동차 등록증 조회
    public Optional<CarRegistration> findById(Long id){
        return Optional.ofNullable(entityManager.find(CarRegistration.class, id));
    }
    //    자동차 등록증 전체 조회
    public List<CarRegistration> findAll(){
        String query = "select c from CarRegistration c";
        return entityManager.createQuery(query, CarRegistration.class).getResultList();
    }
    //    자동차 등록증 삭제
    public void delete(CarRegistration carRegistration){
        entityManager.remove(carRegistration);
    }
}
