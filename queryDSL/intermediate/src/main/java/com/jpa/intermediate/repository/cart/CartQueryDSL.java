package com.jpa.intermediate.repository.cart;

import com.jpa.intermediate.domain.CartDTO;
import com.jpa.intermediate.entity.Cart;

import java.util.List;

public interface CartQueryDSL {
//    전체 조회
    public List<CartDTO> findAll_QueryDSL();
}
