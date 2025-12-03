package com.inkle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkle.service.PostService;
import com.inkle.service.UserService;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final PostService postService;

    public AdminController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id, "ADMIN");
        return "User deleted by admin";
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id) {

        postService.deletePost(id, "ADMIN");
        return "Post deleted by admin";
    }
}