package com.jpa.intermediate.repository.cart;

import com.jpa.intermediate.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long>, CartQueryDSL {
}
