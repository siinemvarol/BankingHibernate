package com.banking.controller;

import com.banking.app.BAUtils;
import com.banking.entity.User;
import com.banking.service.UserService;

import java.util.Optional;

public class UserController {

    private UserService userService;

    public UserController(){
        this.userService = new UserService();
    }

    public void saveUser(){
        String name = BAUtils.readString("İsminizi girin ");
        String email = BAUtils.readString("Email girin ");
        String password = BAUtils.readString("Password girin ");

        User user = new User(name,email,password);
        userService.save(user);

    }

    public User login() {
        String email = BAUtils.readString("Email girin ");
        String password = BAUtils.readString("Password girin ");
        Optional<User> optionalUser = userService.findByEmail(email);
        return optionalUser.get();

    }
}
