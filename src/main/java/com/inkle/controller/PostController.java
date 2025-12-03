package com.inkle.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkle.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/posts")
public class PostController {
   private PostService postService;

   public PostController (PostService postService){
    this.postService= postService;
   }
   @PostMapping
   public Object createPost(@RequestParam Long id,@RequestParam String content){
  return  postService.createPost(id,content);
   }

   @GetMapping
   public Object getAllPosts(@RequestParam Long requesterId) {
       return postService.getAllPosts(requesterId);
   }
   @DeleteMapping("/{id}")
   public String deletePost(@PathVariable Long id,@RequestParam String role){
    postService.deletePost(id, role);
    return "post deleted successfully";
   }
   
}
