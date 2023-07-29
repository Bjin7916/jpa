package com.jpa.intermediate.entity.user;

import com.jpa.intermediate.auditing.Period;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER")
@Getter @Setter @ToString
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends Period { //abstract는 상속관계에서 부모 엔티티를 단독으로 조회하지 말라는 뜻
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String userId;
    private String userPassword;
    private String userName;
    @Embedded
    private Address address;
}
