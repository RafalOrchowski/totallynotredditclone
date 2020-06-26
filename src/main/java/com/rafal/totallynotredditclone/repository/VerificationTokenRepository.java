package com.rafal.totallynotredditclone.repository;

import com.rafal.totallynotredditclone.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
