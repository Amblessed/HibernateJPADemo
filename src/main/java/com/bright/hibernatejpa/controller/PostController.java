package com.bright.hibernatejpa.controller;

/*
 * @Project Name: HibernateJPADemo
 * @Author: Okechukwu Bright Onwumere
 * @Created: 24/11/2022
 */

import com.bright.hibernatejpa.models.Post;
import com.bright.hibernatejpa.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.findAllPost();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts/user/{id}/posts")
    public List<Post> getPostsByUser(@PathVariable Long id) {
        return postService.getPostsByUser(id);
    }



}
