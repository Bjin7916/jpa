package com.jpa.intermediate.repository.product;

import com.jpa.intermediate.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
