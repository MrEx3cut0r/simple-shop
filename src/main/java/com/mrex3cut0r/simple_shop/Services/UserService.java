package com.mrex3cut0r.simple_shop.Services;

import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository user_repository;

    public void DeleteUser(Long id) {user_repository.deleteById(id);}
    public Object findByUsername(String username) {
        return user_repository.findByUsername(username);
    }
    public List<User> getAll() {return user_repository.findAll();}
    public Optional<User> findUser(Long id) {return user_repository.findById(id);}

    public Object CreateUser(User user) {

        if (user.username.length() < 5)
            return "Short username.";

        if (user_repository.findByUsername(user.username).orElse(null) != null)
            return "User already exists";

        return user_repository.save(user);

    }

    public User UpdateUser(Long id, User new_user) {
        User found_user = user_repository.findById(id).orElse(null);
        if (found_user != null) {
            found_user.update_user(new_user);
            return user_repository.save(found_user);
        }
        return null;
    }

    public Object check_password(String username, String password) {
        User found_user = user_repository.findByUsername(username).orElse(null);
        return found_user != null ? found_user.password.equals(password) : null;
    }



}
