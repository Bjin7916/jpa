package com.jpa.intermediate.entity.user;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_COMPANY")
@Getter @Setter @ToString(callSuper = true)
public class Company extends User{
    @NotNull private String businessNumber;
}
