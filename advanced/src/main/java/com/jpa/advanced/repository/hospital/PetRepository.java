package com.jpa.advanced.repository.hospital;

import com.jpa.advanced.entity.hospital.Pet;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
//    LAZY일 때에는 JPA의 findAll()은 연관객체 조회 시 그 만큼의 쿼리가 발생한다.
//    원하는 연관객체만 가져오고 싶다면, 직접 join을 작성한다.
//    @Query("select p, p.owner from Pet p inner join p.owner")
    @EntityGraph(attributePaths="owner")
//    @Query("select p from Pet p")
    public List<Pet> findAll();

//    연관객체의 정보까지 조회할 때에는 직접 inner join을 사용할 필요가 없다.
    @Query("select p, p.owner from Pet p where p.petDisease = :petDisease")
    public List<Pet> findAllByPetDisease(String petDisease);
}
