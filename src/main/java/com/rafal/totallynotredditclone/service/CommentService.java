package com.rafal.totallynotredditclone.service;

import com.rafal.totallynotredditclone.dto.CommentsDto;
import com.rafal.totallynotredditclone.exceptions.PostNotFoundException;
import com.rafal.totallynotredditclone.mapper.CommentMapper;
import com.rafal.totallynotredditclone.model.Comment;
import com.rafal.totallynotredditclone.model.NotificationEmail;
import com.rafal.totallynotredditclone.model.Post;
import com.rafal.totallynotredditclone.model.User;
import com.rafal.totallynotredditclone.repository.CommentRepository;
import com.rafal.totallynotredditclone.repository.PostRepository;
import com.rafal.totallynotredditclone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentService {
    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final MailBuilder mailBuilder;
    private final MailService mailService;

    public void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentsDto, post, authenticationService.getCurrentUser());
        commentRepository.save(comment);

        String message = mailBuilder.build(post.getUser().getUsername() + " posted a comment on your post." + POST_URL);
        sendCommentNotification(message, post.getUser());
    }

    private void sendCommentNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + "Commented on your post", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto).collect(toList());
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(toList());
    }
}
