package com.kdt.please.domain.user.repository;

import com.kdt.please.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
