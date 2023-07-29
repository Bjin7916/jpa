package com.jpa.intermediate.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
public class CartDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private int count;
    private String memberName;
    private int age;
    private String productName;
    private Integer productPrice;
    private Integer productStock;

    @QueryProjection
    public CartDTO(Long id, int count, String memberName, int age, String productName, Integer productPrice, Integer productStock) {
        this.id = id;
        this.count = count;
        this.memberName = memberName;
        this.age = age;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}
