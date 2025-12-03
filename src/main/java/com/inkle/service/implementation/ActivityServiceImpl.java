package com.inkle.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inkle.entity.Activity;
import com.inkle.repository.ActivityRepository;
import com.inkle.repository.PostRepository;
import com.inkle.repository.UserRepository;
import com.inkle.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository, UserRepository userRepository,
            PostRepository postRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    @Override
    public void logActivity(String activityType, Long actorId, Long targetUserId, Long targetPostId) {
      Activity activity=new Activity();
      activity.setType(activityType);
      activity.setActorUser(userRepository.findById(actorId).orElse(null));

      if(targetUserId!=null){
        activity.setTargetUser(userRepository.findById(targetUserId).orElse(null));
      }
      if(targetPostId!=null){
        activity.setTargetPost(postRepository.findById(targetPostId).orElse(null));
      }
      activityRepository.save(activity);
    }

    @Override
    public List<Activity> getActivitiesFeed(Long requesterId) {
        return activityRepository.findAllByOrderByCreatedAtDesc();
    }

}
