package com.inkle.service.implementation;

import org.springframework.stereotype.Service;

import com.inkle.entity.Follow;
import com.inkle.repository.FollowRepository;
import com.inkle.service.ActivityService;
import com.inkle.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final ActivityService activityService;
    public FollowServiceImpl(FollowRepository followRepository, ActivityService activityService){
        this.followRepository = followRepository;
        this.activityService = activityService;
    }
    @Override
    public void followUser(Long followerId, Long followedId) {
       Follow follow=new Follow();
       follow.setFollower(new com.inkle.entity.User(followerId));
       follow.setFollowed(new com.inkle.entity.User(followedId));
       followRepository.save(follow);
       activityService.logActivity("USER_FOLLOWED", followerId, followedId, null);
    }

    @Override
    public void unfollowUser(Long followerId, Long followedId) {
      followRepository.deleteByFollowerIdAndFollowedId(followerId,followedId);
      activityService.logActivity("USER_UNFOLLOWED", followerId, followedId, null);
    }
 
}
