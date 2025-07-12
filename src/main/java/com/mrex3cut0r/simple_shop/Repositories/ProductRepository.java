package com.mrex3cut0r.simple_shop.Repositories;

import com.mrex3cut0r.simple_shop.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByPrice (int price);
}
