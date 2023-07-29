package com.jpa.intermediate.controller;

import com.jpa.intermediate.domain.CartDTO;
import com.jpa.intermediate.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/carts/api/*")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("list")
    public List<CartDTO> getList(){
        return cartService.getList();
    }
}
