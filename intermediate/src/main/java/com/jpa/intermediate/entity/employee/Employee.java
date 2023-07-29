package com.jpa.intermediate.entity.employee;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_EMPLOYEE")
@Getter @Setter @ToString
//    상속관계 시 부모 엔티티에 작성하며, 기본 전략은 SINGLE_TABLE이다.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DEPARTMENT")
public class Employee {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String employeeName;
    private LocalDate employeeBirth;
    @NotNull private int employeeCareer;
}


















