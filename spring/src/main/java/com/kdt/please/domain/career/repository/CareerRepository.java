package com.kdt.please.domain.career.repository;

import com.kdt.please.domain.career.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {
    @Query(value = "select * from career c join resume r where c.resume_id=r.resume_id and r.resume_id=:resumeId", nativeQuery = true)
    List<Career> findByResumeId(@Param("resumeId") Long resumeId);
}
