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
    public String email;
    public Integer balance;
    public boolean show_balance;
    public boolean seller;

    public User(String username, String password, String email, boolean b, boolean b1) {

    }

    public User(String username, String password, boolean show_balance, boolean seller) {
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.show_balance = show_balance;
        this.seller = seller;
    }

    public void update_user(User new_user) {
        this.username = new_user.username;
        this.password = new_user.password;
        this.seller = new_user.seller;
        this.show_balance = new_user.show_balance;
        this.email = new_user.email;

    }

}
