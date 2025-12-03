package com.inkle.service;

import java.util.List;


import com.inkle.entity.Activity;


public interface ActivityService {
  
    void logActivity(String activityType, Long actorId, Long targetUserId,Long targetPostId);

    List<Activity> getActivitiesFeed(Long requesterId);    
} 
