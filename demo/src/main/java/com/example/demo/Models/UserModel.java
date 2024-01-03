package com.example.demo.Models;

import jakarta.persistence.*;
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
