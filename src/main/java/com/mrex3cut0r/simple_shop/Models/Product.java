package com.mrex3cut0r.simple_shop.Models;

import jakarta.persistence.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.transaction.jta.UserTransactionAdapter;

import java.util.Date;

@Table(name="products")
@Entity
    public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String username;
    public String Author;
    public String product_name;
    public Integer price;

    public Product () {

    }

    public Product (String username, String Author, String product_name, Integer price) {
        this.username = username;
        this.Author = Author;
        this.product_name = product_name;
        this.price = price;
    }

}
