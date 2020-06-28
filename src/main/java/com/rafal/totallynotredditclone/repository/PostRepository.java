package com.rafal.totallynotredditclone.repository;

import com.rafal.totallynotredditclone.model.Post;
import com.rafal.totallynotredditclone.model.Subreddit;
import com.rafal.totallynotredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
