package com.mrex3cut0r.simple_shop.Services;

import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository product_repository;
    @Autowired
    private RedisService redis_service;
    public Product findById(Long id) {
        Product product = (Product) redis_service.findProduct(id);
        if (product != null) {
            return product;
        }

        product = product_repository.findById(id).orElse(null);
        if (product != null) {
            redis_service.addProduct((Product)product);
            return product;
        }

        return null;

    }
    public List<Product> getAll() {return product_repository.findAll();}
    public void CreateProduct(Product product) {product_repository.save(product);}
    public void DeleteProduct(Long id) {product_repository.deleteById(id);}

    public List<Product> findByPrice(int starts, int ends) {
        List<Product> products = new ArrayList<Product>();
        for (int i = starts; i<=ends;i++) {
            if (product_repository.findByPrice(i) != null)
                products.add(product_repository.findByPrice(i));
        }
        return products.size() != 0 ? products : null;

    }

    public List<Product> findByAllUsername(String username) {
        return product_repository.findAllByUsername(username);
    }


}
