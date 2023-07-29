package com.jpa.intermediate.entity.computer;

import com.jpa.intermediate.repository.ComputerRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class ComputerRepositoryTests {
    @Autowired
    private ComputerRepository computerRepository;


    @Test
    public void saveTest(){
        Hardware hardware = new Hardware();
        hardware.setRam(8);
        hardware.setSsd(1024);
        hardware.setGpu("RTX4090");
        hardware.setProcessor("i7-12600U");

        Computer computer = new Computer();
        computer.setComputerBrand("SAMSUNG");
        computer.setComputerName("갤럭시 북 프로2");
        computer.setComputerPrice(1_700_000);
        computer.setComputerReleaseDate(LocalDateTime.now());
        computer.setComputerScreen(2880);
        computer.setHardware(hardware);

        computerRepository.save(computer);
    }

    @Test
    public void findByHardwareRamTest(){
//        log.info(computerRepository.findByHardwareRam(16).get(0).toString());
        assertThat(computerRepository.findByHardwareRam(16)).hasSize(1);
    }

    @Test
    public void findHardWareByIdTest(){
        computerRepository.findHardWareById(9L).ifPresent(hardware -> log.info(hardware.toString()));
    }


}




















