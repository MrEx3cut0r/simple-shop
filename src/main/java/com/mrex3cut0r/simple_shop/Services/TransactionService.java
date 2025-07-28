package com.mrex3cut0r.simple_shop.Services;

import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Models.Transaction;
import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TransactionService {
    @Autowired
    private TransactionsRepository repository;
    @Autowired
    private UserService user_service;

    @Autowired
    private ProductService product_service;

    public Transaction findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Object Transaction (User first_user, User second_user, int amount_of_money, Long product_id) throws Exception{
        Product product = product_service.findById(product_id);

        if (first_user == null || second_user == null || product == null) {
            return null;
        }

        if (second_user.balance >= amount_of_money) {
            first_user.balance += amount_of_money;
            second_user.balance -= amount_of_money;
            user_service.UpdateUser(first_user.id, first_user);
            user_service.UpdateUser(second_user.id, second_user);
            product.username = second_user.username;
            product_service.CreateProduct(product);
            return new Transaction(first_user.id, second_user.id, amount_of_money, product_id);
        }

        return false;

    }

}
