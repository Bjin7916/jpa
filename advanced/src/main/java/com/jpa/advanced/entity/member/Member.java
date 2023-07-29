package com.jpa.advanced.entity.member;

import com.jpa.advanced.auditing.Period;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_MEMBER")
@Getter @Setter @ToString
public class Member extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String memberId;
    @NotNull private String memberPassword;
    @NotNull private String memberEmail;
    @Embedded private MemberAddress memberAddress;
}
