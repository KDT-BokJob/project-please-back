package com.kdt.please.domain.resume.repository;

import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
