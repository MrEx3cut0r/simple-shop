package com.mrex3cut0r.simple_shop.Models;


import jakarta.persistence.*;

@Table(name="users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void update_user(User new_user) {
        this.username = new_user.ret_username();
        this.password = new_user.ret_password();
    }

    public String ret_username(){return username;}
    public Long ret_id() {return id;}
    public String ret_password() {return password;}
}
