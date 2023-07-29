package com.jpa.intermediate.entity;

import com.jpa.intermediate.repository.cart.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class EntityTests {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void saveTest(){
        final Member member = Member.builder().memberName("한동석").age(20).build();
        final Product product = Product.builder().productName("자전거").productPrice(590000).productStock(10).build();
        final Cart cart = Cart.builder().count(2).member(member).product(product).build();
        cartRepository.save(cart);
    }
}
