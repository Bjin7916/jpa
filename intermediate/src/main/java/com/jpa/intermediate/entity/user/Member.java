package com.jpa.intermediate.entity.user;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MEMBER")
@Getter @Setter @ToString
public class Member extends User{
    @NotNull private String socialSecurityNumber;
}
