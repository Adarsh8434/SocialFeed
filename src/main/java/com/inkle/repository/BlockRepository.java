package com.inkle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inkle.entity.Block;


@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {

    void deleteByBlockerIdAndBlockedId(Long blockerId, Long blockedId);

}
