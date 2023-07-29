package com.jpa.intermediate.entity.computer;

import com.jpa.intermediate.repository.ComputerDAO;
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
public class ComputerDaoTests {
    @Autowired
    private ComputerDAO computerDAO;

    @Test
    public void saveTest(){
        Hardware hardware = new Hardware();
        Computer computer = new Computer();

        hardware.setRam(16);
        hardware.setSsd(1024);
        hardware.setGpu("RTX4090");
        hardware.setProcessor("i7-12345U");

        computer.setComputerBrand("SAMSUNG");
        computer.setComputerName("갤럭시 북 프로3");
        computer.setComputerPrice(2_000_000);
        computer.setComputerReleaseDate(LocalDateTime.now());
        computer.setComputerScreen(2880);
        computer.setHardware(hardware);

        computerDAO.save(computer);
    }

    @Test
    public void findByIdTest(){
        computerDAO.findById(2L).ifPresentOrElse(
                computer -> {
                    assertThat(computer.getHardware().getRam()).isEqualTo(16);
                },
                () -> {
            log.info("존재하지 않는 컴퓨터입니다.");
        });
    }

    @Test
    public void findAllTest(){
        assertThat(computerDAO.findAll()).hasSize(2);
    }

    @Test
    public void updateTest(){
//        ram 8GB 조회 후 가격을 30만원 인하
//        computerDAO.findAll().stream().filter(computer -> computer.getHardware().getRam() == 8)
        computerDAO.findByRam(8)
                .forEach(computer -> computer.setComputerPrice(computer.getComputerPrice() - 300_000));
    }

    @Test
    public void removeTest(){
        computerDAO.findByRam(8).forEach(computerDAO::delete);
    }
}
















