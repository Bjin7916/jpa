package com.jpa.intermediate.repository.cart;

import com.jpa.intermediate.domain.CartDTO;
import com.jpa.intermediate.domain.QCartDTO;
import com.jpa.intermediate.entity.Cart;
import com.jpa.intermediate.entity.QCart;
import com.jpa.intermediate.entity.QMember;
import com.jpa.intermediate.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.jpa.intermediate.entity.QCart.cart;
import static com.jpa.intermediate.entity.QMember.member;
import static com.jpa.intermediate.entity.QProduct.product;

@RequiredArgsConstructor
public class CartQueryDSLImpl implements CartQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public List<CartDTO> findAll_QueryDSL() {
        return query.select(
                new QCartDTO(
                        cart.id,
                        cart.count,
                        cart.member.memberName,
                        cart.member.age,
                        cart.product.productName,
                        cart.product.productPrice,
                        cart.product.productStock
                        )
//                여러 개의 테이블을 join하여 fetchJoin을 사용하고자 할 때에는
//                그래프 탐색으로 join하지 않고 직접 엔티티로 조인을 한다.
//        ).from(cart).join(member).on(cart.member.id.eq(member.id)).join(product).on(cart.product.id.eq(product.id)).fetchJoin().fetch();
//                그래프 탐색으로 join할 때에는 아래와 같이 해당 객체가 어떤 엔티티인지 같이 작성해 준다.
//        ).from(cart).join(cart.product, product).join(cart.member, member).fetch();
//                select 절에서 그래프 탐색을 사용하면 자동으로 필요한 부분이 join되기 때문에
//                join 쿼리를 보고 불필요한 쿼리가 발생하지 않았다면 이 방법을 사용한다.
        ).from(cart).fetch();
    }
}
