package com.kdt.please.domain.apply.repository;

import com.kdt.please.domain.apply.Apply;
import com.kdt.please.domain.apply.service.response.ApplyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ApplyRepository extends JpaRepository<Apply, Long> {
    Page<Apply> findAllByUser_UserId(Long userId, Pageable pageable);

    Page<Apply> findAllByRecruit_RecruitId(Long recruitId, Pageable pageable);

    Optional<Apply> findByRecruit_RecruitId(Long recruitId);

    @Query(value = "select count(*) from apply a where a.recruit_id=:recruitId", nativeQuery = true)
    int getApplicantCountByRecruitId(@Param("recruitId") Long recruitId);
  
    Optional<Apply> findByRecruit_RecruitIdAndUser_UserId(Long recruitId, Long userId);
}