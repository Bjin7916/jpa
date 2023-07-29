package com.jpa.intermediate.service;

import com.jpa.intermediate.domain.CartDTO;
import com.jpa.intermediate.repository.cart.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public List<CartDTO> getList() {
        return cartRepository.findAll_QueryDSL();
    }
}
