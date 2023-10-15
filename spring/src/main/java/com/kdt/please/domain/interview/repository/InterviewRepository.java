package com.kdt.please.domain.interview.repository;

import com.kdt.please.domain.recruit.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Recruit, Long> {
}
