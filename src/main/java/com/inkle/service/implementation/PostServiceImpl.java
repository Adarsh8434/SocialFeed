package com.inkle.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inkle.entity.Post;
import com.inkle.entity.User;
import com.inkle.repository.PostRepository;
import com.inkle.repository.UserRepository;
import com.inkle.service.ActivityService;
import com.inkle.service.PostService;

@Service
public class PostServiceImpl implements PostService {
  
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ActivityService activityService;
    
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, ActivityService activityService){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.activityService = activityService;
        
    }   

    @Override
    public Post createPost(Long userId, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setUser(user);
        post.setContent(content);

        Post savedPost = postRepository.save(post);

        activityService.logActivity("POST_CREATED", userId, null, savedPost.getId());

        return savedPost;
    }

    @Override
    public List<Post> getAllPosts(Long requesterId) {
       return postRepository.findAll();
    }

    @Override
    public void deletePost(Long postId, String role) {
          if (!role.equals("ADMIN") && !role.equals("OWNER")) {
            throw new RuntimeException("Only admin/owner can delete posts");
        }

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setDeleted(true);
        postRepository.save(post);

        activityService.logActivity("POST_DELETED", null, null, postId);
    }
    

}
