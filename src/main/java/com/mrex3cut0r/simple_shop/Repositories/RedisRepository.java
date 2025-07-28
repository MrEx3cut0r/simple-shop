package com.mrex3cut0r.simple_shop.Repositories;

import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository {
    public void addUser(User user);
    public void addProduct(Product product);
    public void deleteUser(Long id);
    public void deleteProduct(Long id);
    public User findUser(Long id);
    public Product findProduct(Long id);

}
