package com.jpa.intermediate.entity;

import com.jpa.intermediate.audit.Period;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @ToString
@Table(name = "TBL_PRODUCT")
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String productName;
    @ColumnDefault(value = "0")
    private Integer productPrice;
    @ColumnDefault(value = "0")
    private Integer productStock;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Cart> carts = new ArrayList<>();

    @Builder
    public Product(String productName, Integer productPrice, Integer productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}
