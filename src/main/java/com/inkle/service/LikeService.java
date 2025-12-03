package com.inkle.service;


public interface LikeService {
     void likePost(Long postId, Long userId);
        void unlikePost(Long postId, Long userId);
    
}
