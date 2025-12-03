package com.inkle.service;

import java.util.List;

import com.inkle.entity.Post;


public interface PostService {
    Post createPost(Long userId, String content);
    List<Post> getAllPosts(Long requesterId);
    void deletePost(Long postId, String role);
    
} 
