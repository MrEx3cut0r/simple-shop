package com.mrex3cut0r.simple_shop.Services;

import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository product_repository;

    public void findById(Long id) {product_repository.findById(id);}

    public void create_product(Product product) {product_repository.save(product);}

    public Object findByPrice(int starts, int ends) {
        List<Product> products = new ArrayList<Product>();
        for (int i = starts; i<=ends;i++) {
            if (product_repository.findByPrice(i) != null)
                products.add(product_repository.findByPrice(i));
        }
        return products.size() != 0 ? products : "No products found.";

    }
}
