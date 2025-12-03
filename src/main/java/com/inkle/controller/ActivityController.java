package com.inkle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.inkle.service.ActivityService;
import com.inkle.dto.ActivityResponseDTO;
import com.inkle.entity.Activity;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityService activityService;
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

   @GetMapping("/feed")
public List<ActivityResponseDTO> getFeed(@RequestParam Long requesterId) {

    List<Activity> activities=activityService.getActivitiesFeed(requesterId);

    List<ActivityResponseDTO> response=new ArrayList<>();

    for (Activity activity:activities) {

        String message="";

        switch (activity.getType()) {
            case "POST_CREATED":
                message=activity.getActorUser().getName() +"made a post";
                break;

            case "LIKED":
                message=activity.getActorUser().getName()+" liked "
                        +activity.getTargetPost().getUser().getName()+"'s post";
                break;

            case "FOLLOWED":
                message=activity.getActorUser().getName()+" followed "
                        +activity.getTargetUser().getName();
                break;

            case "USER_DELETED":
                message="User deleted by ‘"+activity.getActorUser().getRole()+"’";
                break;

            case "POST_DELETED":
                message="Post deleted by '"+activity.getActorUser().getRole()+"'";
                break;

            default:
                message = "Unknown activity";
        }

        response.add(new ActivityResponseDTO(message));
    }

    return response;
}


}
