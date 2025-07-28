package com.mrex3cut0r.simple_shop.Controllers;

import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Models.Transaction;
import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.Services.ProductService;
import com.mrex3cut0r.simple_shop.Services.TransactionService;
import com.mrex3cut0r.simple_shop.Services.UserService;

import com.mrex3cut0r.simple_shop.tools.jwtToken;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private ProductService product_service;
    @Autowired
    private UserService user_service;
    @Autowired
    private TransactionService transaction_service;


    @GetMapping("/products")
    public List<Product> products() {
        return product_service.getAll();
    }

    @PostMapping("/buy")
    public ResponseEntity<?> buy(HttpServletRequest request, @RequestParam Long id) throws Exception {
        Product product = product_service.findById(id);
        if (product == null)
            return ResponseEntity.ok(null);
        User current = (User)jwtToken.get_user(request, user_service);
        User seller = user_service.findByUsername(product.username);

        Object transaction = transaction_service.Transaction(current,seller, product.price, product.id);
        return ResponseEntity.ok(transaction);

    }

}
