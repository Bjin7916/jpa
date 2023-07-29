package com.jpa.intermediate.service;

import com.jpa.intermediate.domain.CartDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
//    전체 목록
    public List<CartDTO> getList();
}
