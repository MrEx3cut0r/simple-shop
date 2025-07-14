package com.mrex3cut0r.simple_shop.Controllers;

import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.Services.ProductService;
import com.mrex3cut0r.simple_shop.Services.UserService;
import com.mrex3cut0r.simple_shop.tools.jwtToken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/me")
public class PersonalController{

    @Autowired
    private UserService user_service;
    @Autowired
    private ProductService product_service;



    @GetMapping("/")
    @ResponseBody
    public Object me(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object user = jwtToken.get_user(request, user_service);
        return user;
    }

    @PostMapping("/create-product")
    @ResponseBody
    public Product create_product(HttpServletRequest request, @RequestParam String author, @RequestParam String name, @RequestParam int price) {
        String user = (String)jwtToken.get_username(request);
        Product product = new Product(user, author, name, price);
        product_service.CreateProduct(product);
        return product;
    }

    @GetMapping("/products")
    public List<Product> my_products(HttpServletRequest request) {
        return product_service.findByAllUsername((String)jwtToken.get_username(request));
    }

}
