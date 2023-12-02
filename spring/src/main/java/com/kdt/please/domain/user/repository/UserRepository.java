package com.kdt.please.domain.user.repository;

import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.service.response.UserInfoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(Long userId);
    Optional<User> findByEmail(String email);
}
