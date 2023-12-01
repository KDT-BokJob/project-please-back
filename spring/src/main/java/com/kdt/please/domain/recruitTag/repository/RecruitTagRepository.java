package com.kdt.please.domain.recruitTag.repository;

import com.kdt.please.domain.recruitTag.RecruitTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecruitTagRepository extends JpaRepository<RecruitTag, Long> {

    Optional<RecruitTag> findByName(String name);
}