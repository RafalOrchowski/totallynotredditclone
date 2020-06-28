package com.rafal.totallynotredditclone.repository;

import com.rafal.totallynotredditclone.model.Comment;
import com.rafal.totallynotredditclone.model.Post;
import com.rafal.totallynotredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
