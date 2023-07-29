package com.jpa.advanced.entity.hospital;

import com.jpa.advanced.repository.hospital.OwnerDAO;
import com.jpa.advanced.repository.hospital.PetDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class PetTests {
    @Autowired
    private PetDAO petDAO;
    @Autowired
    private OwnerDAO ownerDAO;

    @Test
    public void saveTest(){
//        Owner owner = new Owner();
//        owner.setOwnerName("한동석");
//        owner.setOwnerPhone("01012341234");
//
//        ownerDAO.save(owner);

//        Pet pet = new Pet();
//        final Optional<Owner> foundOwner = ownerDAO.findById(13L);
//
//        pet.setPetName("톰");
//        pet.setPetGender(GenderType.MALE);
//        pet.setPetDisease("감기");
//
//        foundOwner.ifPresent(owner -> owner.getPets().add(pet));

//        Owner owner = new Owner();
//        owner.setOwnerName("이순신");
//        owner.setOwnerPhone("01055556666");
//
//        ownerDAO.save(owner);

        final Optional<Owner> foundOwner = ownerDAO.findById(15L);
        final Optional<Pet> foundPet = petDAO.findById(14L);
        foundOwner.ifPresent(owner -> foundPet.ifPresent(pet -> pet.setOwner(owner)));

    }

    @Test
    public void findByIdTest(){

    }

    @Test
    public void findAllTest(){
        petDAO.findAll().forEach(pet -> {
            log.info(pet.getOwner().getOwnerName());
        });
    }

    @Test
    public void updateTest(){
        petDAO.findById(14L).ifPresent(pet -> pet.getOwner().setOwnerName("뽀삐"));
    }

    @Test
    public void deleteTest(){
        final Optional<Owner> foundOwner = ownerDAO.findById(12L);
        foundOwner.ifPresent(ownerDAO::delete);
    }
}






















