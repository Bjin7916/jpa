package com.jpa.intermediate.entity.computer;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

//    Embeddable
//    상속관계가 아닌 필드의 그룹화(모듈화)를 목적으로 사용한다.
//    그룹화된 필드는 따로 사용하지 않고 한 번에 사용하는 목적으로 설계한다.

@Embeddable
@Getter @Setter @ToString
public class Hardware {
    @NotNull private int ram;
    @NotNull private int ssd;
    @NotNull private String gpu;
    @NotNull private String processor;
}
