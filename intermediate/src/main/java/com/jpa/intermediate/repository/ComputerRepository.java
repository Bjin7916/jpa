package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.computer.Computer;
import com.jpa.intermediate.entity.computer.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
//    ram으로 컴퓨터 조회
//    @Query("select c from Computer c where c.hardware.ram = :ram")
    public List<Computer> findByHardwareRam(int ram);

//    컴퓨터를 1개 조회 후 하드웨어 정보만 가져오기
    @Query("select c.hardware from Computer c where c.id = :id")
    public Optional<Hardware> findHardWareById(Long id);
}
