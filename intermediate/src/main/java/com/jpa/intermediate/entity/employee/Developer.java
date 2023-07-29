package com.jpa.intermediate.entity.employee;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_DEVELOPER")
@Getter @Setter @ToString
@DynamicInsert // 필드에 null이 들어가 있다면 INSERT 쿼리에 해당 필드를 제외해준다.
@DynamicUpdate // 필드에 null이 들어가 있다면 UPDATE 쿼리 SET절에 해당 필드를 제외해준다.
@DiscriminatorValue("dev")
public class Developer extends Employee{
    private int developerLevel;
//    컬럼의 초기값 설정, @DynamicInsert와 같이 사용해야 한다.
    @ColumnDefault(value = "0")
    private Integer projectCount;
}





















