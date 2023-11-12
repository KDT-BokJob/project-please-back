package com.kdt.please.domain.userVisa.repository;

import com.kdt.please.domain.userVisa.UserVisa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserVisaRepository extends JpaRepository<UserVisa, Long> {
    Optional<UserVisa> findByUser_UserId(Long userId);
    void deleteByUser_UserId(Long userId);
}
