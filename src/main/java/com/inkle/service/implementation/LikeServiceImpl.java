package com.inkle.service.implementation;


import org.springframework.stereotype.Service;

import com.inkle.entity.Like;
import com.inkle.entity.Post;
import com.inkle.entity.User;
import com.inkle.repository.LikeRepository;
import com.inkle.service.ActivityService;
import com.inkle.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final ActivityService activityService;
    public LikeServiceImpl(LikeRepository likeRepository, ActivityService activityService){
        this.likeRepository = likeRepository;
        this.activityService = activityService;
    }
      public void likePost(Long postId, Long userId) {
        Like like = new Like();
        like.setPost(new Post(postId));
        like.setUser(new User(userId));

        likeRepository.save(like);

        activityService.logActivity("LIKED", userId, null, postId);
    }


    @Override
    public void unlikePost(Long postId, Long userId) {
        likeRepository.deleteByPostIdAndUserId(postId, userId);

        activityService.logActivity("Dislike the post", userId, null, postId);
    }

}
