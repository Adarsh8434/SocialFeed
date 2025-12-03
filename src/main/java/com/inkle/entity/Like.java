package com.inkle.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="likes")
public class Like {
        @Id
        @GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post post;
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

}
