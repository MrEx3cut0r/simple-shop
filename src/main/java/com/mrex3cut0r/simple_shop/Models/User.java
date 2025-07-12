package com.mrex3cut0r.simple_shop.Models;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String username;
    public String password;

    public Integer balance;

    public boolean show_balance = false;

    public User() {

    }

    public User(String username, String password, boolean show_balance) {
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.show_balance = false;
    }

    public void update_user(User new_user) {
        this.username = new_user.username;
        this.password = new_user.password;
    }

}
