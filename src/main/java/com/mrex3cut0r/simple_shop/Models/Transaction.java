package com.mrex3cut0r.simple_shop.Models;

import jakarta.persistence.*;

@Table(name="Transactions")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long first_id;
    public Long second_id;
    public int price;
    public Long product_id;

    Transaction() {

    }

    public Transaction(Long first_id, Long second_id, int price, Long product_id) {
        this.first_id = first_id;
        this.second_id = second_id;
        this.price = price;
        this.product_id = product_id;
    }
}
