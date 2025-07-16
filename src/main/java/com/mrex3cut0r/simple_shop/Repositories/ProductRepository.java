package com.mrex3cut0r.simple_shop.Repositories;

import com.mrex3cut0r.simple_shop.Models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByPrice (int price);
    public List<Product> findAllByUsername(String username);

}
