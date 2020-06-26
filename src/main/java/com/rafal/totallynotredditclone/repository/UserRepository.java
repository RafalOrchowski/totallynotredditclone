package com.rafal.totallynotredditclone.repository;

import com.rafal.totallynotredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
