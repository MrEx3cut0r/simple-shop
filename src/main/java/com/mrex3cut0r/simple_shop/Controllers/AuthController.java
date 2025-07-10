package com.mrex3cut0r.simple_shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mrex3cut0r.simple_shop.Services.UserService;
import com.mrex3cut0r.simple_shop.Models.User;



@RestController
public class AuthController {
    @Autowired
    private UserService service;

    @PostMapping("/create-user")
    public User register(@RequestBody User user) {
        try {
            return service.CreateUser(user);
        } catch (Exception e) {throw e;}
    }

    @GetMapping("/")
    public Iterable<User> get_all() {
        return service.getAll();
    }


}
