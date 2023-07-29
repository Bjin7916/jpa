package com.jpa.expert.repository.car;

import com.jpa.expert.entity.car.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
//    자동차 추가
    public Car save(Car car){
        entityManager.persist(car);
        return car;
    }
//    자동차 조회
    public Optional<Car> findById(Long id){
        return Optional.ofNullable(entityManager.find(Car.class, id));
    }
//    자동차 전체 조회
    public List<Car> findAll(){
        String query = "select c from Car c";
        return entityManager.createQuery(query, Car.class).getResultList();
    }
//    자동차 삭제
    public void delete(Car car){
        entityManager.remove(car);
    }
}
