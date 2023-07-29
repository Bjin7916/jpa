package com.jpa.intermediate.entity.computer;

import com.jpa.intermediate.auditing.Period;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_COMPUTER")
public class Computer extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private int computerScreen;
    @NotNull private String computerBrand;
    @NotNull private String computerName;
    @NotNull private int computerPrice;
    @NotNull private LocalDateTime computerReleaseDate;
    @Embedded //@Embeddable 클래스를 사용할 때 작성한다.
    @NotNull private Hardware hardware;
}





















