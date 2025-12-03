package com.inkle.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    @Id
   @GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime createdAt=LocalDateTime.now();
    private boolean isDeleted=false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(Long id) { this.id = id; }

}
