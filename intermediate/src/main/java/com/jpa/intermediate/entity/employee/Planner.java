package com.jpa.intermediate.entity.employee;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_PLANNER")
@DynamicInsert
@Getter @Setter @ToString(callSuper = true)
@DiscriminatorValue("pln")
public class Planner extends Employee {
    private int plannerOaLevel;
    @ColumnDefault(value = "0")
    private Integer clientCount;
}


















