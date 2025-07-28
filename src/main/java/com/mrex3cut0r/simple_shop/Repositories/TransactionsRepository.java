package com.mrex3cut0r.simple_shop.Repositories;

import com.mrex3cut0r.simple_shop.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
}
