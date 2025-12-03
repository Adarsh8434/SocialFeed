package com.inkle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inkle.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
