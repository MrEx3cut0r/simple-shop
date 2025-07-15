package com.mrex3cut0r.simple_shop.Controllers;

import com.mrex3cut0r.simple_shop.Services.UserService;
import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.tools.jwtToken;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService service;

    @PostMapping("/create-user")
    public Object register(@RequestParam String username, @RequestParam String password,@RequestParam String email) {return service.CreateUser(new User(username, password,email , false, false));}

    @PostMapping("/login")
    public Object login(HttpServletResponse response, @RequestParam String username, @RequestParam String password) {
        Object check = service.check_password(username, password);
        if (check == null) {
            return "User not found.";
        }
        if ((boolean)check){
            Cookie cookie = new Cookie("jwt", jwtToken.generate(username));
            cookie.setMaxAge(3600000);
            cookie.setPath("/");
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
