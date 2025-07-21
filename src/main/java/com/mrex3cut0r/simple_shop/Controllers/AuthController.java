package com.mrex3cut0r.simple_shop.Controllers;

import com.mrex3cut0r.simple_shop.Services.UserService;
import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.tools.jwtToken;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService service;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/register")
    public Object register(@RequestParam String username, @RequestParam String password,@RequestParam String email) {return service.CreateUser(new User(username, password,email , false, false));}

    @PostMapping("/login")
    public Object login(ModelMap model, HttpServletResponse response, @RequestParam String username, @RequestParam String password) {
        Object check = service.check_password(username, password);
        if (check == null) {
            return new ModelAndView("redirect:/auth/signin", model);
        }
        if ((boolean)check){
            Cookie cookie = new Cookie("jwt", jwtToken.generate(username));
            cookie.setMaxAge(3600000);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ModelAndView("redirect:/me/", model);
        }
        return new ModelAndView("redirect:/auth/signin", model);
    }
    @PutMapping("/logout")
    @ResponseBody
    public ModelAndView logout_action(ModelMap model, HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/auth/signin", model);
    }

}
