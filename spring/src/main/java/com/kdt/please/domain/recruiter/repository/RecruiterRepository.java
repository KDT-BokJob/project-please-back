package com.kdt.please.domain.recruiter.repository;

import com.kdt.please.domain.recruit.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruit, Long> {
}
