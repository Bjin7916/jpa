package com.jpa.expert.repository.car;

import com.jpa.expert.entity.car.CarOwner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CarOwnerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //    차주 추가
    public CarOwner save(CarOwner carOwner){
        entityManager.persist(carOwner);
        return carOwner;
    }
    //    차주 조회
    public Optional<CarOwner> findById(Long id){
        return Optional.ofNullable(entityManager.find(CarOwner.class, id));
    }
    //    차주 전체 조회
    public List<CarOwner> findAll(){
        String query = "select c from CarOwner c";
        return entityManager.createQuery(query, CarOwner.class).getResultList();
    }
    //    차주 삭제
    public void delete(CarOwner carOwner){
        entityManager.remove(carOwner);
    }
}
