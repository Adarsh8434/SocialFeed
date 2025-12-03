package com.inkle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inkle.entity.Like;


@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {

    void deleteByPostIdAndUserId(Long postId, Long userId);

}
