package com.mrex3cut0r.simple_shop.Controllers;

import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Services.ProductService;
import com.mrex3cut0r.simple_shop.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private ProductService product_service;
    @Autowired
    private UserService user_service;

    @GetMapping("/products")
    public List<Product> products() {
        return product_service.getAll();
    }

}
