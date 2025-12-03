package com.inkle.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkle.service.FollowService;

@RestController
@RequestMapping("/follow")

public class FollowController {
  private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping
    public String followUser(@RequestParam Long followerId,
                             @RequestParam Long followedId) {

        followService.followUser(followerId, followedId);
        return "Followed successfully";
    }

    @DeleteMapping
    public String unfollowUser(@RequestParam Long followerId,
                               @RequestParam Long followedId) {

        followService.unfollowUser(followerId, followedId);
        return "Unfollowed successfully";
    }
}
