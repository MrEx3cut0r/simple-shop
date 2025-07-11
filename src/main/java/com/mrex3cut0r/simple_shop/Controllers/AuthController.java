package com.mrex3cut0r.simple_shop.Controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mrex3cut0r.simple_shop.Services.UserService;
import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.tools.jwtToken;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthController {
    @Autowired
    private UserService service;

    @PostMapping("/create-user")
    public Object register(@RequestParam String username, @RequestParam String password) {
        return service.CreateUser(new User(username, password));
    }
    /*
    @GetMapping("/")
    @ResponseBody
    public Object get_all() {
        return service.getAll().size() != 0 ? service.getAll() : "No users found.";
    }
    */

    @PostMapping("/login")
    public Object login(HttpServletResponse response, @RequestParam Long id, @RequestParam String password) {
        if ((boolean)service.check_password(id, password)) {
            Cookie cookie = new Cookie("jwt", jwtToken.generate(id));
            response.addCookie(cookie);
            return "Successfully authenticated.";
        }
        return false;
    }
    @GetMapping("/logout")
    @ResponseBody
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.ok("Successfully logged out!");
    }

}
