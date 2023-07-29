package com.jpa.expert.entity.car;

import com.jpa.expert.repository.car.CarDAO;
import com.jpa.expert.repository.car.CarOwnerDAO;
import com.jpa.expert.repository.car.CarRegistrationDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CarTests {

    @Autowired
    private CarDAO carDAO;
    @Autowired
    private CarOwnerDAO carOwnerDAO;
    @Autowired
    private CarRegistrationDAO carRegistrationDAO;

    @Test
    public void saveTest(){
        Car car = new Car();
        CarOwner carOwner = new CarOwner();
        CarOwnerAddress carOwnerAddress = new CarOwnerAddress();
        CarRegistration carRegistration = new CarRegistration();

        car.setCarBrand(CarBrand.FERRARI);
        car.setCarName("488 Spider");
        car.setCarPrice(700_000_000L);
        car.setCarReleaseDate(LocalDateTime.now());

        carOwnerAddress.setCarOwnerAddress("서울");
        carOwnerAddress.setCarOwnerAddressDetail("강남");
        carOwnerAddress.setCarOwnerZipcode("12345");

        carOwner.setCarOwnerAddress(carOwnerAddress);
        carOwner.setCarOwnerName("한동석");
        carOwner.setCarOwnerAge(20);

        carRegistration.setCarOwner(carOwner);
        carRegistration.setCar(car);

        carDAO.save(car);
        carOwnerDAO.save(carOwner);
        carRegistrationDAO.save(carRegistration);
    }

    @Test
    public void findByIdTest(){
        carDAO.findById(1L).ifPresentOrElse(car -> {
            log.info(car.toString());
        }, () -> {
            log.info("삭제 혹은 없는 자동차입니다.");
        });

//        Car car = carDAO.findById(1L).orElseThrow(() -> {throw new RuntimeException();});
    }

//    기존 자동차의 차주를 다른 차주로 변경
    @Test
    public void updateTest(){
        final Optional<Car> foundCar = carDAO.findById(13L);
        CarOwner carOwner = new CarOwner();
        CarOwnerAddress carOwnerAddress = new CarOwnerAddress();
        CarRegistration carRegistration = new CarRegistration();

        carOwnerAddress.setCarOwnerAddress("경기도");
        carOwnerAddress.setCarOwnerAddressDetail("남양주");
        carOwnerAddress.setCarOwnerZipcode("99898");

        carOwner.setCarOwnerAddress(carOwnerAddress);
        carOwner.setCarOwnerName("홍길동");
        carOwner.setCarOwnerAge(40);

        carOwnerDAO.save(carOwner);

        foundCar.ifPresent(car -> {
            carRegistration.setCar(car);
            carRegistration.setCarOwner(carOwner);
            carRegistrationDAO.save(carRegistration);
        });
    }
    
    @Test
    public void deleteTest(){
        final Optional<Car> foundCar = carDAO.findById(1L);
        foundCar.ifPresent(carDAO::delete);
    }

    @Test
    public void findAllTest(){
        carRegistrationDAO.findAll().forEach(carRegistration -> {
            log.info(carRegistration.toString());
        });
    }
}





