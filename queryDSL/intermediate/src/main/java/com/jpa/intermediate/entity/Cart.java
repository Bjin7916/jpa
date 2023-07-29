package com.jpa.intermediate.entity;

import com.jpa.intermediate.audit.Period;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @ToString
@Table(name = "TBL_CART")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private int count;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public Cart(int count, Product product, Member member) {
        this.count = count;
        this.product = product;
        this.member = member;
    }
}
