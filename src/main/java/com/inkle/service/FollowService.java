package com.inkle.service;


public interface FollowService {
   void followUser(Long followerId, Long followedId);
   void unfollowUser(Long followerId,Long followedId);
   
   
} 
