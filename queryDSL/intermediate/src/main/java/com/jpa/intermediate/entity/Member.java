package com.jpa.intermediate.entity;

import com.jpa.intermediate.audit.Period;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @ToString
@Table(name = "TBL_MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String memberName;
    private int age;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Cart> carts = new ArrayList<>();

    @Builder
    public Member(String memberName, int age) {
        this.memberName = memberName;
        this.age = age;
    }
}
