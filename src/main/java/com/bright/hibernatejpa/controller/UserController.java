package com.bright.hibernatejpa.controller;

/*
 * @Project Name: HibernateJPADemo
 * @Author: Okechukwu Bright Onwumere
 * @Created: 24/11/2022
 */


import com.bright.hibernatejpa.models.Post;
import com.bright.hibernatejpa.models.User;
import com.bright.hibernatejpa.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id).orElse(null);
    }

    @GetMapping("/users/{id}/post")
    public List<Post> getUsersByLocation(@PathVariable Long id){
        return userService.getUserById(id).map(User::getPosts).orElseThrow(null);
    }
}
