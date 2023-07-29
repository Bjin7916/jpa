package com.jpa.advanced.entity.hospital;

import com.jpa.advanced.repository.hospital.OwnerRepository;
import com.jpa.advanced.repository.hospital.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class PetRepositoryTests {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void petTest(){
//        final Optional<Owner> foundOwner = ownerRepository.findById(5L);
        Pet pet = new Pet();

        pet.setPetName("마이크");
        pet.setPetGender(GenderType.FEMALE);
        pet.setPetDisease("장염");
//        foundOwner.ifPresent(pet::setOwner);

        petRepository.save(pet);
    }

    @Test
    public void findAllTest(){
        log.info(petRepository.findAll().toString());

//        final List<Pet> foundPets = petRepository.findAll();
//        log.info(foundPets.get(0).getOwner().getOwnerName());
//        log.info(foundPets.get(1).getOwner().getOwnerName());

//        log.info(petRepository.findAllByPetDisease("감기").toString());
    }
}












