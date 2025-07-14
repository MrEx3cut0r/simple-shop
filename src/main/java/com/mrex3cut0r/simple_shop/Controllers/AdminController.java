package com.mrex3cut0r.simple_shop.Controllers;

import com.mrex3cut0r.simple_shop.Services.UserService;
import com.mrex3cut0r.simple_shop.tools.jwtToken;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    @ResponseBody
    public Object get_all() {
        return service.getAll().size() != 0 ? service.getAll() : "No users found.";
    }

    @PostMapping("/delete/{id}")
    public Long delete_user(@PathVariable Long id) {
        service.DeleteUser(id);
        return id;
    }


}
