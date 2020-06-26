package com.rafal.totallynotredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subreddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(fetch = LAZY) //creates subreddit_posts
    private List<Post> posts;
    private Instant createdDate; // could be LocalDateTime
    @ManyToOne(fetch = LAZY) //creates use_user_id column
    private User user;
}
