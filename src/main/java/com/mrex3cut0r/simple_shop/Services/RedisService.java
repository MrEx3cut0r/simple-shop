package com.mrex3cut0r.simple_shop.Services;

import com.mrex3cut0r.simple_shop.Configs.RedisConfig;
import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.Repositories.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService implements RedisRepository {
    @Autowired
    private RedisTemplate<String, Object> template;
    private static final String HASH_KEY1 = "USER";
    private static final String HASH_KEY2 = "PRODUCT";

    public void addUser(User user) {
        System.out.println("created user");
        template.opsForHash().put(HASH_KEY1, user.id, user);
    }

    public void addProduct(Product product) {
        System.out.println("created product");template.opsForHash().put(HASH_KEY1, product.id, product);
    }


    public void deleteUser(Long id) {
        template.opsForHash().delete(HASH_KEY1, id);
    }

    public void deleteProduct(Long id) {
        template.opsForHash().delete(HASH_KEY2, id);
    }

    public Object findUser(Long id) {
        return template.opsForHash().get(HASH_KEY1, id);
    }
    public Object findProduct(Long id) {
        return template.opsForHash().get(HASH_KEY2, id);
    }

}
