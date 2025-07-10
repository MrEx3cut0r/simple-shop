package com.mrex3cut0r.simple_shop.Services;

import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository user_repository;

    public User CreateUser(User user) {
        return user_repository.save(user);
    }

    public void DeleteUser(Long id) {
        user_repository.deleteById(id);
    }

    public User UpdateUser(Long id, User new_user) {
        User found_user = user_repository.findById(id).orElse(null);
        if (found_user != null) {
            found_user.update_user(new_user);
            return user_repository.save(found_user);
        }
        return null;
    }

    public Optional<User> findUser(Long id) {
        return user_repository.findById(id);
    }

    public Iterable<User> getAll() {
        return user_repository.findAll();
    }

    public Object check_password(Long id, String password) {
        User found_user = user_repository.findById(id).orElse(null);
        if (found_user != null) {
            if (found_user.ret_password() == password) {
                return true;
            }
            return false;
        }
        return null;
    }

}
