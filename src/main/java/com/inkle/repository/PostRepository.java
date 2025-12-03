package com.inkle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inkle.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
