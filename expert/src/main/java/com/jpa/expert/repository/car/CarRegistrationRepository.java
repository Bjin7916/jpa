package com.jpa.expert.repository.car;

import com.jpa.expert.entity.car.Car;
import com.jpa.expert.entity.car.CarBrand;
import com.jpa.expert.entity.car.CarRegistration;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRegistrationRepository extends JpaRepository<CarRegistration, Long> {

    @EntityGraph(attributePaths={"car", "carOwner"})
    public List<CarRegistration> findAll();

    //    자동차가 FERRARI인 차주들의 평균 나이 구하기
    @Query("select avg(r.carOwner.carOwnerAge) from CarRegistration r join fetch r.carOwner join fetch r.car where r.car.carName = 'FERRARI'")
    public int findAverageOfAge();

    //    자동차(id)마다 전차주들과 현차주의 평균 나이가 60세~70세 사이인 자동차 정보 조회
    @Query("select c from Car c where c.id in (select r.car.id from CarRegistration r group by r.car.id having avg(r.carOwner.carOwnerAge) between 60 and 70)")
    public List<Car> findAllCarByAge();

//    현차주의 나이가 90세 이상이면 자동차 폐차







}




















