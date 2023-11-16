package com.kdt.please.domain.resume.repository;

import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    @Query("select r from Resume r where r.user.userId=:userId")
    Optional<Resume> findByUserId(@Param("userId") Long userId);
}