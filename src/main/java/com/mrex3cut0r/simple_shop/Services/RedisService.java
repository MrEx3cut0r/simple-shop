package com.mrex3cut0r.simple_shop.Services;

import com.mrex3cut0r.simple_shop.Configs.RedisConfig;
import com.mrex3cut0r.simple_shop.Models.Product;
import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.Repositories.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedisService implements RedisRepository {
    @Autowired
    private RedisTemplate<String, Object> template;
    private static final String HASH_KEY1 = "USER";
    private static final String HASH_KEY2 = "PRODUCT";
    @CachePut
    public void addUser(User user) {
        System.out.println("created user");
        template.opsForHash().put(HASH_KEY1, user.id, user);
    }
    @CachePut
    public void addProduct(Product product) {
        System.out.println("created product");template.opsForHash().put(HASH_KEY1, product.id, product);
    }

    @CacheEvict
    public void deleteUser(Long id) {
        template.opsForHash().delete(HASH_KEY1, id);
    }
    @CacheEvict
    public void deleteProduct(Long id) {
        template.opsForHash().delete(HASH_KEY2, id);
    }
    @Cacheable
    public User findUser(Long id) {
        return (User) template.opsForHash().get(HASH_KEY1, id);
    }
    @Cacheable
    public Product findProduct(Long id) {
        return (Product) template.opsForHash().get(HASH_KEY2, id);
    }

}
