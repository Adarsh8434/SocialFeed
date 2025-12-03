package com.inkle.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkle.service.LikeService;
@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) { this.likeService = likeService; }

    @PostMapping
    public String likePost(@RequestParam Long postId,
                           @RequestParam Long userId) {

        likeService.likePost(postId, userId);
        return "Post liked successfully";
    }

    @DeleteMapping
    public String unlikePost(@RequestParam Long postId,
                             @RequestParam Long userId) {

        likeService.unlikePost(postId, userId);
        return "Post unliked successfully";
    }
}