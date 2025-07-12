package com.mrex3cut0r.simple_shop.Models;

import jakarta.persistence.*;
import org.springframework.transaction.jta.UserTransactionAdapter;

import java.util.Date;

@Table
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String product_name;
    public Integer price;

}
